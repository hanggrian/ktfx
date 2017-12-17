@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.util.Builder
import kotfx.internal.ServiceDsl

interface ServiceBuilder<V> : Builder<Service<V>> {
    fun onCall(action: Task<V>.() -> V)
    fun onReady(action: (WorkerStateEvent) -> Unit)
    fun onScheduled(action: (WorkerStateEvent) -> Unit)
    fun onRunning(action: (WorkerStateEvent) -> Unit)
    fun onSucceeded(action: (WorkerStateEvent) -> Unit)
    fun onCancelled(action: (WorkerStateEvent) -> Unit)
    fun onFailed(action: (WorkerStateEvent) -> Unit)

    fun start(): Service<V>
}

@PublishedApi
internal class FXServiceBuilder<V> : ServiceBuilder<V> {
    private var mOnCall: (Task<V>.() -> V)? = null
    private var mOnReady: ((WorkerStateEvent) -> Unit)? = null
    private var mOnScheduled: ((WorkerStateEvent) -> Unit)? = null
    private var mOnRunning: ((WorkerStateEvent) -> Unit)? = null
    private var mOnSucceeded: ((WorkerStateEvent) -> Unit)? = null
    private var mOnCancelled: ((WorkerStateEvent) -> Unit)? = null
    private var mOnFailed: ((WorkerStateEvent) -> Unit)? = null

    override fun onCall(action: Task<V>.() -> V) {
        mOnCall = action
    }

    override fun onReady(action: (WorkerStateEvent) -> Unit) {
        mOnReady = action
    }

    override fun onScheduled(action: (WorkerStateEvent) -> Unit) {
        mOnScheduled = action
    }

    override fun onRunning(action: (WorkerStateEvent) -> Unit) {
        mOnRunning = action
    }

    override fun onSucceeded(action: (WorkerStateEvent) -> Unit) {
        mOnSucceeded = action
    }

    override fun onCancelled(action: (WorkerStateEvent) -> Unit) {
        mOnCancelled = action
    }

    override fun onFailed(action: (WorkerStateEvent) -> Unit) {
        mOnFailed = action
    }

    override fun build(): Service<V> = object : Service<V>() {
        override fun createTask(): Task<V> = object : Task<V>() {
            override fun call(): V = checkNotNull(mOnCall) { "Service unavailable before configuring onCall." }(this)
        }
    }.apply {
        mOnReady?.let { setOnReady(it) }
        mOnScheduled?.let { setOnScheduled(it) }
        mOnRunning?.let { setOnRunning(it) }
        mOnSucceeded?.let { setOnSucceeded(it) }
        mOnCancelled?.let { setOnCancelled(it) }
        mOnFailed?.let { setOnFailed(it) }
    }

    override fun start(): Service<V> = build().apply { start() }
}

inline fun <V> service(init: (@ServiceDsl ServiceBuilder<V>).() -> Unit): ServiceBuilder<V> = FXServiceBuilder<V>().apply(init)
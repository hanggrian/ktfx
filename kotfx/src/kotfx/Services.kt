package kotfx

import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.util.Builder

interface ServiceBuilder<V> : Builder<Service<V>> {
    fun onCall(action: Task<V>.() -> V)
    fun onReady(action: (WorkerStateEvent) -> Unit)
    fun onScheduled(action: (WorkerStateEvent) -> Unit)
    fun onRunning(action: (WorkerStateEvent) -> Unit)
    fun onSucceeded(action: (WorkerStateEvent) -> Unit)
    fun onCancelled(action: (WorkerStateEvent) -> Unit)
    fun onFailed(action: (WorkerStateEvent) -> Unit)
}

@PublishedApi
internal class _ServiceBuilder<V> : ServiceBuilder<V> {
    private var _onCall: (Task<V>.() -> V)? = null
    private var _onReady: ((WorkerStateEvent) -> Unit)? = null
    private var _onScheduled: ((WorkerStateEvent) -> Unit)? = null
    private var _onRunning: ((WorkerStateEvent) -> Unit)? = null
    private var _onSucceeded: ((WorkerStateEvent) -> Unit)? = null
    private var _onCancelled: ((WorkerStateEvent) -> Unit)? = null
    private var _onFailed: ((WorkerStateEvent) -> Unit)? = null

    override fun onCall(action: Task<V>.() -> V) {
        _onCall = action
    }

    override fun onReady(action: (WorkerStateEvent) -> Unit) {
        _onReady = action
    }

    override fun onScheduled(action: (WorkerStateEvent) -> Unit) {
        _onScheduled = action
    }

    override fun onRunning(action: (WorkerStateEvent) -> Unit) {
        _onRunning = action
    }

    override fun onSucceeded(action: (WorkerStateEvent) -> Unit) {
        _onSucceeded = action
    }

    override fun onCancelled(action: (WorkerStateEvent) -> Unit) {
        _onCancelled = action
    }

    override fun onFailed(action: (WorkerStateEvent) -> Unit) {
        _onFailed = action
    }

    override fun build(): Service<V> = object : Service<V>() {
        override fun createTask(): Task<V> = object : Task<V>() {
            override fun call(): V = checkNotNull(_onCall) { "Unable to build Service before configuring onCall" }()
        }
    }.apply {
        if (_onReady != null) setOnReady(_onReady)
        if (_onScheduled != null) setOnScheduled(_onScheduled)
        if (_onRunning != null) setOnRunning(_onRunning)
        if (_onSucceeded != null) setOnSucceeded(_onSucceeded)
        if (_onCancelled != null) setOnCancelled(_onCancelled)
        if (_onFailed != null) setOnFailed(_onFailed)
    }
}

/** Creates a service DSL-style builder. */
inline fun <V> service(init: ServiceBuilder<V>.() -> Unit): Service<V> = _ServiceBuilder<V>().apply(init).build()
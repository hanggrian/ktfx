package kotfx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent

@PublishedApi
internal class FXServiceBuilder<V> : ServiceBuilder<V> {

    private var mService: Service<V>? = null

    @PublishedApi
    internal val service: Service<V> = checkNotNull(mService) { "Service unavailable before configuring onCall." }

    override fun onCall(action: Task<V>.() -> V) {
        mService = object : Service<V>() {
            override fun createTask(): Task<V> = object : Task<V>() {
                override fun call(): V = action()
            }
        }
    }

    override fun onReady(action: (WorkerStateEvent) -> Unit) = service.setOnReady(action)

    override fun onScheduled(action: (WorkerStateEvent) -> Unit) = service.setOnScheduled(action)

    override fun onRunning(action: (WorkerStateEvent) -> Unit) = service.setOnRunning(action)

    override fun onSucceeded(action: (WorkerStateEvent) -> Unit) = service.setOnSucceeded(action)

    override fun onCancelled(action: (WorkerStateEvent) -> Unit) = service.setOnCancelled(action)

    override fun onFailed(action: (WorkerStateEvent) -> Unit) = service.setOnFailed(action)
}
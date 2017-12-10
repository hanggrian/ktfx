package kotfx.concurrent

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent

interface ServiceBuilder<V> {

    fun onCall(action: Task<V>.() -> V)

    fun onReady(action: (WorkerStateEvent) -> Unit)

    fun onScheduled(action: (WorkerStateEvent) -> Unit)

    fun onRunning(action: (WorkerStateEvent) -> Unit)

    fun onSucceeded(action: (WorkerStateEvent) -> Unit)

    fun onCancelled(action: (WorkerStateEvent) -> Unit)

    fun onFailed(action: (WorkerStateEvent) -> Unit)
}
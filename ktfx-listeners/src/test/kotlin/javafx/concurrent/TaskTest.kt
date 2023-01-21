package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseTaskTest
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent

class TaskTest : BaseTaskTest() {
    override fun <E> Task<E>.callOnScheduled(action: (WorkerStateEvent) -> Unit) = onScheduled(
        action
    )
    override fun <E> Task<E>.callOnRunning(action: (WorkerStateEvent) -> Unit) = onRunning(action)
    override fun <E> Task<E>.callOnSucceeded(action: (WorkerStateEvent) -> Unit) = onSucceeded(
        action
    )
    override fun <E> Task<E>.callOnCancelled(action: (WorkerStateEvent) -> Unit) = onCancelled(
        action
    )
    override fun <E> Task<E>.callOnFailed(action: (WorkerStateEvent) -> Unit) = onFailed(action)
}

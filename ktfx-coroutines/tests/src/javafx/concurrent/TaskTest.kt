package ktfx.coroutines

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseTaskTest

class TaskTest : BaseTaskTest() {

    override fun <E> Task<E>.callOnScheduled(action: (WorkerStateEvent) -> Unit) =
        onScheduled(Dispatchers.Unconfined) { action(it) }

    override fun <E> Task<E>.callOnRunning(action: (WorkerStateEvent) -> Unit) =
        onRunning(Dispatchers.Unconfined) { action(it) }

    override fun <E> Task<E>.callOnSucceeded(action: (WorkerStateEvent) -> Unit) =
        onSucceeded(Dispatchers.Unconfined) { action(it) }

    override fun <E> Task<E>.callOnCancelled(action: (WorkerStateEvent) -> Unit) =
        onCancelled(Dispatchers.Unconfined) { action(it) }

    override fun <E> Task<E>.callOnFailed(action: (WorkerStateEvent) -> Unit) =
        onFailed(Dispatchers.Unconfined) { action(it) }
}
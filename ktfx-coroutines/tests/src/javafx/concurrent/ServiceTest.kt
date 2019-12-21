package ktfx.coroutines

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseServiceTest

class ServiceTest : BaseServiceTest() {

    override fun <E> Service<E>.callOnReady(action: (WorkerStateEvent) -> Unit) =
        onReady(Dispatchers.Unconfined) { action(it) }

    override fun <E> Service<E>.callOnScheduled(action: (WorkerStateEvent) -> Unit) =
        onScheduled(Dispatchers.Unconfined) { action(it) }

    override fun <E> Service<E>.callOnRunning(action: (WorkerStateEvent) -> Unit) =
        onRunning(Dispatchers.Unconfined) { action(it) }

    override fun <E> Service<E>.callOnSucceeded(action: (WorkerStateEvent) -> Unit) =
        onSucceeded(Dispatchers.Unconfined) { action(it) }

    override fun <E> Service<E>.callOnCancelled(action: (WorkerStateEvent) -> Unit) =
        onCancelled(Dispatchers.Unconfined) { action(it) }

    override fun <E> Service<E>.callOnFailed(action: (WorkerStateEvent) -> Unit) =
        onFailed(Dispatchers.Unconfined) { action(it) }
}
package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseServiceTest
import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent

class ServiceTest : BaseServiceTest() {
    override fun <E> Service<E>.callOnReady(action: (WorkerStateEvent) -> Unit) = onReady(action)
    override fun <E> Service<E>.callOnScheduled(action: (WorkerStateEvent) -> Unit) = onScheduled(
        action
    )
    override fun <E> Service<E>.callOnRunning(action: (WorkerStateEvent) -> Unit) = onRunning(
        action
    )
    override fun <E> Service<E>.callOnSucceeded(action: (WorkerStateEvent) -> Unit) = onSucceeded(
        action
    )
    override fun <E> Service<E>.callOnCancelled(action: (WorkerStateEvent) -> Unit) = onCancelled(
        action
    )
    override fun <E> Service<E>.callOnFailed(action: (WorkerStateEvent) -> Unit) = onFailed(action)
}

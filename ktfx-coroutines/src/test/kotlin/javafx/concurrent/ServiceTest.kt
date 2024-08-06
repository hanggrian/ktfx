package ktfx.coroutines

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals

class ServiceTest {
    private val service = HelloWorldService()

    @Test
    fun onReady() {
        service.onReady(Dispatchers.Unconfined) {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_READY, it.eventType)
        }
        service.onReady.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_READY))
    }

    @Test
    fun onScheduled() {
        service.onScheduled(Dispatchers.Unconfined) {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SCHEDULED, it.eventType)
        }
        service.onScheduled
            .handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_SCHEDULED))
    }

    @Test
    fun onRunning() {
        service.onRunning(Dispatchers.Unconfined) {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_RUNNING, it.eventType)
        }
        service.onRunning.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_RUNNING))
    }

    @Test
    fun onSucceeded() {
        service.onSucceeded(Dispatchers.Unconfined) {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SUCCEEDED, it.eventType)
        }
        service.onSucceeded
            .handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_SUCCEEDED))
    }

    @Test
    fun onCancelled() {
        service.onCancelled(Dispatchers.Unconfined) {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_CANCELLED, it.eventType)
        }
        service.onCancelled
            .handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_CANCELLED))
    }

    @Test
    fun onFailed() {
        service.onFailed(Dispatchers.Unconfined) {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_FAILED, it.eventType)
        }
        service.onFailed.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_FAILED))
    }

    class HelloWorldService : Service<String>() {
        override fun createTask() = TaskTest.HelloWorldTask()
    }
}

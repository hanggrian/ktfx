package ktfx.coroutines

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.Test
import kotlin.test.assertEquals

class TaskTest {
    private val task = HelloWorldTask()

    @Test
    fun onScheduled() {
        task.onScheduled(Dispatchers.Unconfined) {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SCHEDULED, it.eventType)
        }
        task.onScheduled.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_SCHEDULED))
    }

    @Test
    fun onRunning() {
        task.onRunning(Dispatchers.Unconfined) {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_RUNNING, it.eventType)
        }
        task.onRunning.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_RUNNING))
    }

    @Test
    fun onSucceeded() {
        task.onSucceeded(Dispatchers.Unconfined) {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SUCCEEDED, it.eventType)
        }
        task.onSucceeded.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_SUCCEEDED))
    }

    @Test
    fun onCancelled() {
        task.onCancelled(Dispatchers.Unconfined) {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_CANCELLED, it.eventType)
        }
        task.onCancelled.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_CANCELLED))
    }

    @Test
    fun onFailed() {
        task.onFailed(Dispatchers.Unconfined) {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_FAILED, it.eventType)
        }
        task.onFailed.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_FAILED))
    }

    class HelloWorldTask : Task<String>() {
        override fun call() = "Hello world"
    }
}

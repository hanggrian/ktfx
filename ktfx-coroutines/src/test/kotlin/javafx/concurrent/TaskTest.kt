package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TaskTest : ApplicationTest() {
    lateinit var task: HelloWorldTask

    override fun start(stage: Stage) {
        stage.testScene<Task<*>>()
        task = HelloWorldTask()
    }

    @Test
    fun onScheduled() {
        interact {
            task.onScheduled {
                assertEquals(task, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_SCHEDULED, it.eventType)
            }
            task.onScheduled.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_SCHEDULED))
        }
    }

    @Test
    fun onRunning() {
        interact {
            task.onRunning {
                assertEquals(task, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_RUNNING, it.eventType)
            }
            task.onRunning.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_RUNNING))
        }
    }

    @Test
    fun onSucceeded() {
        interact {
            task.onSucceeded {
                assertEquals(task, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_SUCCEEDED, it.eventType)
            }
            task.onSucceeded.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_SUCCEEDED))
        }
    }

    @Test
    fun onCancelled() {
        interact {
            task.onCancelled {
                assertEquals(task, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_CANCELLED, it.eventType)
            }
            task.onCancelled.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_CANCELLED))
        }
    }

    @Test
    fun onFailed() {
        interact {
            task.onFailed {
                assertEquals(task, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_FAILED, it.eventType)
            }
            task.onFailed.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_FAILED))
        }
    }

    class HelloWorldTask : Task<String>() {
        override fun call() = "Hello world"
    }
}

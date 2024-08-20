package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ServiceTest : ApplicationTest() {
    lateinit var service: HelloWorldService

    override fun start(stage: Stage) {
        stage.testScene<Service<*>>()
        service = HelloWorldService()
    }

    @Test
    fun onReady() {
        interact {
            service.onReady {
                assertEquals(service, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_READY, it.eventType)
            }
            service.onReady.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_READY))
        }
    }

    @Test
    fun onScheduled() {
        interact {
            service.onScheduled {
                assertEquals(service, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_SCHEDULED, it.eventType)
            }
            service.onScheduled
                .handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_SCHEDULED))
        }
    }

    @Test
    fun onRunning() {
        interact {
            service.onRunning {
                assertEquals(service, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_RUNNING, it.eventType)
            }
            service.onRunning.handle(
                WorkerStateEvent(
                    service,
                    WorkerStateEvent.WORKER_STATE_RUNNING,
                ),
            )
        }
    }

    @Test
    fun onSucceeded() {
        interact {
            service.onSucceeded {
                assertEquals(service, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_SUCCEEDED, it.eventType)
            }
            service.onSucceeded
                .handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_SUCCEEDED))
        }
    }

    @Test
    fun onCancelled() {
        interact {
            service.onCancelled {
                assertEquals(service, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_CANCELLED, it.eventType)
            }
            service.onCancelled
                .handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_CANCELLED))
        }
    }

    @Test
    fun onFailed() {
        interact {
            service.onFailed {
                assertEquals(service, it.source)
                assertEquals(WorkerStateEvent.WORKER_STATE_FAILED, it.eventType)
            }
            service.onFailed.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_FAILED))
        }
    }

    class HelloWorldService : Service<String>() {
        override fun createTask() = TaskTest.HelloWorldTask()
    }
}

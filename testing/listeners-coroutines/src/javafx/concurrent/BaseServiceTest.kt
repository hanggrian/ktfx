package io.github.hendraanggrian.ktfx.test

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseServiceTest {

    class HelloWorldService : Service<String>() {
        override fun createTask() = BaseTaskTest.HelloWorldTask()
    }

    private val service = HelloWorldService()

    abstract fun <E> Service<E>.callOnReady(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Service<E>.callOnScheduled(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Service<E>.callOnRunning(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Service<E>.callOnSucceeded(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Service<E>.callOnCancelled(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Service<E>.callOnFailed(action: (WorkerStateEvent) -> Unit)

    @Test fun onReady() {
        service.callOnReady {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_READY, it.eventType)
        }
        service.onReady.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_READY))
    }

    @Test fun onScheduled() {
        service.callOnScheduled {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SCHEDULED, it.eventType)
        }
        service.onScheduled.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_SCHEDULED))
    }

    @Test fun onRunning() {
        service.callOnRunning {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_RUNNING, it.eventType)
        }
        service.onRunning.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_RUNNING))
    }

    @Test fun onSucceeded() {
        service.callOnSucceeded {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SUCCEEDED, it.eventType)
        }
        service.onSucceeded.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_SUCCEEDED))
    }

    @Test fun onCancelled() {
        service.callOnCancelled {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_CANCELLED, it.eventType)
        }
        service.onCancelled.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_CANCELLED))
    }

    @Test fun onFailed() {
        service.callOnFailed {
            assertEquals(service, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_FAILED, it.eventType)
        }
        service.onFailed.handle(WorkerStateEvent(service, WorkerStateEvent.WORKER_STATE_FAILED))
    }
}
package com.hendraanggrian.ktfx.test

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTaskTest {

    class HelloWorldTask : Task<String>() {
        override fun call() = "Hello world"
    }

    private val task = HelloWorldTask()

    abstract fun <E> Task<E>.callOnScheduled(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Task<E>.callOnRunning(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Task<E>.callOnSucceeded(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Task<E>.callOnCancelled(action: (WorkerStateEvent) -> Unit)
    abstract fun <E> Task<E>.callOnFailed(action: (WorkerStateEvent) -> Unit)

    @Test
    fun onScheduled() {
        task.callOnScheduled {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SCHEDULED, it.eventType)
        }
        task.onScheduled.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_SCHEDULED))
    }

    @Test
    fun onRunning() {
        task.callOnRunning {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_RUNNING, it.eventType)
        }
        task.onRunning.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_RUNNING))
    }

    @Test
    fun onSucceeded() {
        task.callOnSucceeded {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_SUCCEEDED, it.eventType)
        }
        task.onSucceeded.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_SUCCEEDED))
    }

    @Test
    fun onCancelled() {
        task.callOnCancelled {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_CANCELLED, it.eventType)
        }
        task.onCancelled.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_CANCELLED))
    }

    @Test
    fun onFailed() {
        task.callOnFailed {
            assertEquals(task, it.source)
            assertEquals(WorkerStateEvent.WORKER_STATE_FAILED, it.eventType)
        }
        task.onFailed.handle(WorkerStateEvent(task, WorkerStateEvent.WORKER_STATE_FAILED))
    }
}
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.property.*
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.Worker
import javafx.concurrent.WorkerStateEvent
import javafx.event.EventHandler
import kotfx.internal.ServiceDsl

interface _Service<V> {
    val service: Service<V>

    fun call(action: Task<V>.() -> V)

    val stateProperty: ReadOnlyObjectProperty<Worker.State> get() = service.stateProperty()
    val state: Worker.State get() = service.state

    val valueProperty: ReadOnlyObjectProperty<V> get() = service.valueProperty()
    val value: V get() = service.value

    val exceptionProperty: ReadOnlyObjectProperty<Throwable> get() = service.exceptionProperty()
    val exception: Throwable get() = service.exception

    val totalProperty: ReadOnlyDoubleProperty get() = service.totalWorkProperty()
    val total: Double get() = service.totalWork

    val progressProperty: ReadOnlyDoubleProperty get() = service.progressProperty()
    val progress: Double get() = service.progress

    val runningProperty: ReadOnlyBooleanProperty get() = service.runningProperty()
    val isRunning: Boolean get() = service.isRunning

    val messageProperty: ReadOnlyStringProperty get() = service.messageProperty()
    val message: String get() = service.message

    val titleProperty: ReadOnlyStringProperty get() = service.titleProperty()
    val title: String get() = service.title

    val onReadyProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = service.onReadyProperty()
    val onReady: EventHandler<WorkerStateEvent> get() = service.onReady
    fun onReady(action: (WorkerStateEvent) -> Unit) = service.setOnReady(action)

    val onScheduledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = service.onScheduledProperty()
    val onScheduled: EventHandler<WorkerStateEvent> get() = service.onScheduled
    fun onScheduled(action: (WorkerStateEvent) -> Unit) = service.setOnScheduled(action)

    val onRunningProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = service.onRunningProperty()
    val onRunning: EventHandler<WorkerStateEvent> get() = service.onRunning
    fun onRunning(action: (WorkerStateEvent) -> Unit) = service.setOnRunning(action)

    val onSucceededProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = service.onSucceededProperty()
    val onSucceeded: EventHandler<WorkerStateEvent> get() = service.onSucceeded
    fun onSucceeded(action: (WorkerStateEvent) -> Unit) = service.setOnSucceeded(action)

    val onCancelledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = service.onCancelledProperty()
    val onCancelled: EventHandler<WorkerStateEvent> get() = service.onCancelled
    fun onCancelled(action: (WorkerStateEvent) -> Unit) = service.setOnCancelled(action)

    val onFailedProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = service.onFailedProperty()
    val onFailed: EventHandler<WorkerStateEvent> get() = service.onFailed
    fun onFailed(action: (WorkerStateEvent) -> Unit) = service.setOnFailed(action)
}

inline fun <V> service(init: (@ServiceDsl _Service<V>).() -> Unit): Service<V> = object : _Service<V> {
    private var mService: Service<V>? = null

    override val service: Service<V> get() = checkNotNull(mService) { "Service unavailable before configuring call." }

    override fun call(action: Task<V>.() -> V) {
        mService = object : Service<V>() {
            override fun createTask(): Task<V> = object : Task<V>() {
                override fun call(): V = action()
            }
        }
    }
}.apply { init() }.service
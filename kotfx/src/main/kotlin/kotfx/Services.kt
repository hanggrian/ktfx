@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.property.*
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.Worker
import javafx.concurrent.WorkerStateEvent
import javafx.event.EventHandler
import kotfx.internal.ServiceDsl
import kotfx.internal.Instanced

interface _Service<V> : Instanced<Service<V>> {

    fun call(action: Task<V>.() -> V)

    val stateProperty: ReadOnlyObjectProperty<Worker.State> get() = instance.stateProperty()
    val state: Worker.State get() = instance.state

    val valueProperty: ReadOnlyObjectProperty<V> get() = instance.valueProperty()
    val value: V get() = instance.value

    val exceptionProperty: ReadOnlyObjectProperty<Throwable> get() = instance.exceptionProperty()
    val exception: Throwable get() = instance.exception

    val totalProperty: ReadOnlyDoubleProperty get() = instance.totalWorkProperty()
    val total: Double get() = instance.totalWork

    val progressProperty: ReadOnlyDoubleProperty get() = instance.progressProperty()
    val progress: Double get() = instance.progress

    val runningProperty: ReadOnlyBooleanProperty get() = instance.runningProperty()
    val isRunning: Boolean get() = instance.isRunning

    val messageProperty: ReadOnlyStringProperty get() = instance.messageProperty()
    val message: String get() = instance.message

    val titleProperty: ReadOnlyStringProperty get() = instance.titleProperty()
    val title: String get() = instance.title

    val onReadyProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = instance.onReadyProperty()
    val onReady: EventHandler<WorkerStateEvent> get() = instance.onReady
    fun onReady(action: (WorkerStateEvent) -> Unit) = instance.setOnReady(action)

    val onScheduledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = instance.onScheduledProperty()
    val onScheduled: EventHandler<WorkerStateEvent> get() = instance.onScheduled
    fun onScheduled(action: (WorkerStateEvent) -> Unit) = instance.setOnScheduled(action)

    val onRunningProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = instance.onRunningProperty()
    val onRunning: EventHandler<WorkerStateEvent> get() = instance.onRunning
    fun onRunning(action: (WorkerStateEvent) -> Unit) = instance.setOnRunning(action)

    val onSucceededProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = instance.onSucceededProperty()
    val onSucceeded: EventHandler<WorkerStateEvent> get() = instance.onSucceeded
    fun onSucceeded(action: (WorkerStateEvent) -> Unit) = instance.setOnSucceeded(action)

    val onCancelledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = instance.onCancelledProperty()
    val onCancelled: EventHandler<WorkerStateEvent> get() = instance.onCancelled
    fun onCancelled(action: (WorkerStateEvent) -> Unit) = instance.setOnCancelled(action)

    val onFailedProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = instance.onFailedProperty()
    val onFailed: EventHandler<WorkerStateEvent> get() = instance.onFailed
    fun onFailed(action: (WorkerStateEvent) -> Unit) = instance.setOnFailed(action)
}

inline fun <V> service(init: (@ServiceDsl _Service<V>).() -> Unit): Service<V> = object : _Service<V> {
    private var service: Service<V>? = null

    override val instance: Service<V> get() = checkNotNull(service) { "Service unavailable before configuring call." }

    override fun call(action: Task<V>.() -> V) {
        service = object : Service<V>() {
            override fun createTask(): Task<V> = object : Task<V>() {
                override fun call(): V = action()
            }
        }
    }
}.apply { init() }.instance
package kotfx.concurrent

import javafx.beans.property.*
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.Worker
import javafx.concurrent.WorkerStateEvent
import javafx.event.EventHandler
import javafx.util.Builder

interface ServiceBuilder<V> : Builder<Service<V>> {

    fun call(action: Task<V>.() -> V)

    val stateProperty: ReadOnlyObjectProperty<Worker.State>
    val state: Worker.State get() = stateProperty.get()

    val valueProperty: ReadOnlyObjectProperty<V>
    val value: V get() = valueProperty.get()

    val exceptionProperty: ReadOnlyObjectProperty<Throwable>
    val exception: Throwable get() = exceptionProperty.get()

    val totalProperty: ReadOnlyDoubleProperty
    val total: Double get() = totalProperty.get()

    val progressProperty: ReadOnlyDoubleProperty
    val progress: Double get() = progressProperty.get()

    val runningProperty: ReadOnlyBooleanProperty
    val running: Boolean get() = runningProperty.get()

    val messageProperty: ReadOnlyStringProperty
    val message: String get() = messageProperty.get()

    val titleProperty: ReadOnlyStringProperty
    val title: String get() = titleProperty.get()

    val onReadyProperty: ObjectProperty<EventHandler<WorkerStateEvent>>
    fun onReady(action: (WorkerStateEvent) -> Unit)

    val onScheduledProperty: ObjectProperty<EventHandler<WorkerStateEvent>>
    fun onScheduled(action: (WorkerStateEvent) -> Unit)

    val onRunningProperty: ObjectProperty<EventHandler<WorkerStateEvent>>
    fun onRunning(action: (WorkerStateEvent) -> Unit)

    val onSucceededProperty: ObjectProperty<EventHandler<WorkerStateEvent>>
    fun onSucceeded(action: (WorkerStateEvent) -> Unit)

    val onCancelledProperty: ObjectProperty<EventHandler<WorkerStateEvent>>
    fun onCancelled(action: (WorkerStateEvent) -> Unit)

    val onFailedProperty: ObjectProperty<EventHandler<WorkerStateEvent>>
    fun onFailed(action: (WorkerStateEvent) -> Unit)
}
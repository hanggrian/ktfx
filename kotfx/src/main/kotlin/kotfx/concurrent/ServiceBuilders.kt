package kotfx.concurrent

import javafx.beans.property.*
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.Worker
import javafx.concurrent.WorkerStateEvent
import javafx.event.EventHandler
import kotfx.internal.Instanced

@PublishedApi
internal class FXServiceBuilder<V> : ServiceBuilder<V> {

    private var service: Service<V>? = null

    override val t: Service<V> get() = checkNotNull(service) { "Service unavailable before configuring call." }

    override fun call(action: Task<V>.() -> V) {
        service = object : Service<V>() {
            override fun createTask(): Task<V> = object : Task<V>() {
                override fun call(): V = action()
            }
        }
    }

    override fun onReady(action: (WorkerStateEvent) -> Unit) = t.setOnReady(action)

    override fun onScheduled(action: (WorkerStateEvent) -> Unit) = t.setOnScheduled(action)

    override fun onRunning(action: (WorkerStateEvent) -> Unit) = t.setOnRunning(action)

    override fun onSucceeded(action: (WorkerStateEvent) -> Unit) = t.setOnSucceeded(action)

    override fun onCancelled(action: (WorkerStateEvent) -> Unit) = t.setOnCancelled(action)

    override fun onFailed(action: (WorkerStateEvent) -> Unit) = t.setOnFailed(action)
}

interface ServiceBuilder<V> : Instanced<Service<V>> {

    fun call(action: Task<V>.() -> V)

    val stateProperty: ReadOnlyObjectProperty<Worker.State> get() = t.stateProperty()
    val state: Worker.State get() = t.state

    val valueProperty: ReadOnlyObjectProperty<V> get() = t.valueProperty()
    val value: V get() = t.value

    val exceptionProperty: ReadOnlyObjectProperty<Throwable> get() = t.exceptionProperty()
    val exception: Throwable get() = t.exception

    val totalProperty: ReadOnlyDoubleProperty get() = t.totalWorkProperty()
    val total: Double get() = t.totalWork

    val progressProperty: ReadOnlyDoubleProperty get() = t.progressProperty()
    val progress: Double get() = t.progress

    val runningProperty: ReadOnlyBooleanProperty get() = t.runningProperty()
    val isRunning: Boolean get() = t.isRunning

    val messageProperty: ReadOnlyStringProperty get() = t.messageProperty()
    val message: String get() = t.message

    val titleProperty: ReadOnlyStringProperty get() = t.titleProperty()
    val title: String get() = t.title

    val onReadyProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = t.onReadyProperty()
    fun onReady(action: (WorkerStateEvent) -> Unit)

    val onScheduledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = t.onScheduledProperty()
    fun onScheduled(action: (WorkerStateEvent) -> Unit)

    val onRunningProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = t.onRunningProperty()
    fun onRunning(action: (WorkerStateEvent) -> Unit)

    val onSucceededProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = t.onSucceededProperty()
    fun onSucceeded(action: (WorkerStateEvent) -> Unit)

    val onCancelledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = t.onCancelledProperty()
    fun onCancelled(action: (WorkerStateEvent) -> Unit)

    val onFailedProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = t.onFailedProperty()
    fun onFailed(action: (WorkerStateEvent) -> Unit)
}
package kotfx.concurrent

import javafx.beans.property.*
import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.Worker
import javafx.concurrent.WorkerStateEvent
import javafx.event.EventHandler

@PublishedApi
internal class FXServiceBuilder<V> : ServiceBuilder<V> {

    private var service: Service<V>? = null

    private val serviceNotNull: Service<V> get() = checkNotNull(service) { "Service unavailable before configuring call." }

    override fun call(action: Task<V>.() -> V) {
        service = object : Service<V>() {
            override fun createTask(): Task<V> = object : Task<V>() {
                override fun call(): V = action()
            }
        }
    }

    override val stateProperty: ReadOnlyObjectProperty<Worker.State> get() = serviceNotNull.stateProperty()

    override val valueProperty: ReadOnlyObjectProperty<V> get() = serviceNotNull.valueProperty()

    override val exceptionProperty: ReadOnlyObjectProperty<Throwable> get() = serviceNotNull.exceptionProperty()

    override val totalProperty: ReadOnlyDoubleProperty get() = serviceNotNull.totalWorkProperty()

    override val progressProperty: ReadOnlyDoubleProperty get() = serviceNotNull.progressProperty()

    override val runningProperty: ReadOnlyBooleanProperty get() = serviceNotNull.runningProperty()

    override val messageProperty: ReadOnlyStringProperty get() = serviceNotNull.messageProperty()

    override val titleProperty: ReadOnlyStringProperty get() = serviceNotNull.titleProperty()

    override val onReadyProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = serviceNotNull.onReadyProperty()
    override fun onReady(action: (WorkerStateEvent) -> Unit) = serviceNotNull.setOnReady(action)

    override val onScheduledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = serviceNotNull.onScheduledProperty()
    override fun onScheduled(action: (WorkerStateEvent) -> Unit) = serviceNotNull.setOnScheduled(action)

    override val onRunningProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = serviceNotNull.onRunningProperty()
    override fun onRunning(action: (WorkerStateEvent) -> Unit) = serviceNotNull.setOnRunning(action)

    override val onSucceededProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = serviceNotNull.onSucceededProperty()
    override fun onSucceeded(action: (WorkerStateEvent) -> Unit) = serviceNotNull.setOnSucceeded(action)

    override val onCancelledProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = serviceNotNull.onCancelledProperty()
    override fun onCancelled(action: (WorkerStateEvent) -> Unit) = serviceNotNull.setOnCancelled(action)

    override val onFailedProperty: ObjectProperty<EventHandler<WorkerStateEvent>> get() = serviceNotNull.onFailedProperty()
    override fun onFailed(action: (WorkerStateEvent) -> Unit) = serviceNotNull.setOnFailed(action)

    override fun build(): Service<V> = serviceNotNull
}
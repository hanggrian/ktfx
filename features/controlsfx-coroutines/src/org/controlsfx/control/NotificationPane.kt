@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")

package ktfx.controlsfx.coroutines

import javafx.event.Event
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.NotificationPane

/** Called just prior to the [NotificationPane] being shown. */
fun NotificationPane.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [NotificationPane] is shown. */
fun NotificationPane.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnShown { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [NotificationPane] being hidden. */
fun NotificationPane.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [NotificationPane] has been hidden. */
fun NotificationPane.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Called just prior to the [Dialog] being shown. */
fun Dialog<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [Dialog] is shown. */
fun Dialog<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
): Unit = setOnShown { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [Dialog] being hidden. */
fun Dialog<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
): Unit = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [Dialog] has been hidden. */
fun Dialog<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
): Unit = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there is an external request to close this [Dialog]. */
fun Dialog<*>.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
): Unit = setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }

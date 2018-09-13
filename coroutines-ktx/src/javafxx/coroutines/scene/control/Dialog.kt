@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Called when there is an external request to close this [Dialog]. */
fun Dialog<*>.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [Dialog] has been hidden. */
fun Dialog<*>.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [Dialog] being hidden. */
fun Dialog<*>.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [Dialog] being shown. */
fun Dialog<*>.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [Dialog] is shown. */
fun Dialog<*>.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShown { event -> GlobalScope.launch(context) { action(event) } }
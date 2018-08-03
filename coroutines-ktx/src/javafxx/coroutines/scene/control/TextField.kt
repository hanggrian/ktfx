@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The action handler associated with this text field, or `null` if no action handler is assigned. */
fun TextField.onAction(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }
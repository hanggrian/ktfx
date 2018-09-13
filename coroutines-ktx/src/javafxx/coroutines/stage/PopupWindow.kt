@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.stage.PopupWindow
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Specifies whether the PopupWindow should be hidden when an unhandled escape key is pressed while the popup has focus.
 */
fun PopupWindow.onAutoHide(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnAutoHide { event -> GlobalScope.launch(context) { action(event) } }
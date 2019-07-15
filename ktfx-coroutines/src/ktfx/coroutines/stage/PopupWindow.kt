@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.event.Event
import javafx.stage.PopupWindow
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/**
 * Specifies whether the PopupWindow should be hidden when an unhandled escape key is pressed while the popup has focus.
 */
fun PopupWindow.onAutoHide(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnAutoHide { event -> GlobalScope.launch(context) { action(event) } }

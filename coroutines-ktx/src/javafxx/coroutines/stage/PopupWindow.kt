package javafxx.coroutines

import javafx.event.Event
import javafx.stage.PopupWindow
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Specifies whether the PopupWindow should be hidden when an unhandled escape key is pressed while the popup has focus.
 */
fun PopupWindow.onAutoHide(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnAutoHide { event -> launch(context) { action(event) } }
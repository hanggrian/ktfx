package kotfx.stage

import javafx.event.Event
import javafx.stage.PopupWindow
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun PopupWindow.onAutoHide(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnAutoHide { event -> launch(context) { action(event) } }
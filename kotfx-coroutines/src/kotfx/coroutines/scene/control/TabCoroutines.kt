package kotfx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun Tab.onClosed(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnClosed { event -> launch(context) { action(event) } }

fun Tab.onCloseRequest(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

fun Tab.onSelectionChanged(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnSelectionChanged { event -> launch(context) { action(event) } }
package javafxx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Defines a function to be called when the [Tab] is closed. */
fun Tab.onClosed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnClosed { event -> launch(context) { action(event) } }

/** Called when there is an external request to close this [Tab]. */
fun Tab.onCloseRequest(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

/** Defines a function to be called when a selection changed has occurred on the [Tab]. */
fun Tab.onSelectionChanged(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnSelectionChanged { event -> launch(context) { action(event) } }
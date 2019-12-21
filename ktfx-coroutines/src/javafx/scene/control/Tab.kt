@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Defines a function to be called when a selection changed has occurred on the [Tab]. */
fun Tab.onSelectionChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnSelectionChanged { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when the [Tab] is closed. */
fun Tab.onClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnClosed { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there is an external request to close this [Tab]. */
fun Tab.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }

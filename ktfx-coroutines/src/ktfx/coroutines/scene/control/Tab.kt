@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Defines a function to be called when the [Tab] is closed. */
fun Tab.onClosed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnClosed { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there is an external request to close this [Tab]. */
fun Tab.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }

/** Defines a function to be called when a selection changed has occurred on the [Tab]. */
fun Tab.onSelectionChanged(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnSelectionChanged { event -> GlobalScope.launch(context) { action(event) } }
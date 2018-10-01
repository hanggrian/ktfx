@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import javafx.scene.control.TreeView.EditEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the handler that will be called when the user cancels an edit. */
fun <T> TreeView<T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
): Unit = setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the handler that will be called when the user commits an edit. */
fun <T> TreeView<T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
): Unit = setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the handler that will be called when the user begins an edit. */
fun <T> TreeView<T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(EditEvent<T>) -> Unit
): Unit = setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there's a request to scroll an index into view using [TreeView.scrollTo]. */
fun TreeView<*>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }
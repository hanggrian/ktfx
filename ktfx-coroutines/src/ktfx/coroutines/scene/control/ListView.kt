@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Sets the handler that will be called when the user cancels */
fun <T> ListView<T>.onEditCancel(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
): Unit = setOnEditCancel { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the handler that will be called when the user has completed their editing. */
fun <T> ListView<T>.onEditCommit(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
): Unit = setOnEditCommit { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the handler that will be called when the user begins an edit. */
fun <T> ListView<T>.onEditStart(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ListView.EditEvent<T>) -> Unit
): Unit = setOnEditStart { event -> GlobalScope.launch(context) { action(event) } }

/** Called when there's a request to scroll an index into view using [ListView.scrollTo]. */
fun ListView<*>.onScrollTo(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> GlobalScope.launch(context) { action(event) } }
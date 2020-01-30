@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent

/** Sets the handler that will be called when the user begins an edit. */
inline fun <T> ListView<T>.onEditStart(
    noinline action: (ListView.EditEvent<T>) -> Unit
): Unit = setOnEditStart(action)

/** Sets the handler that will be called when the user has completed their editing. */
inline fun <T> ListView<T>.onEditCommit(
    noinline action: (ListView.EditEvent<T>) -> Unit
): Unit = setOnEditCommit(action)

/** Sets the handler that will be called when the user cancels */
inline fun <T> ListView<T>.onEditCancel(
    noinline action: (ListView.EditEvent<T>) -> Unit
): Unit = setOnEditCancel(action)

/** Called when there's a request to scroll an index into view using [ListView.scrollTo]. */
inline fun ListView<*>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo(action)

@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView
import javafx.scene.control.TreeView.EditEvent

/** Sets the handler that will be called when the user begins an edit. */
inline fun <T> TreeView<T>.onEditStart(
    noinline action: (EditEvent<T>) -> Unit
): Unit = setOnEditStart { event -> action(event) }

/** Sets the handler that will be called when the user commits an edit. */
inline fun <T> TreeView<T>.onEditCommit(
    noinline action: (EditEvent<T>) -> Unit
): Unit = setOnEditCommit { event -> action(event) }

/** Sets the handler that will be called when the user cancels an edit. */
inline fun <T> TreeView<T>.onEditCancel(
    noinline action: (EditEvent<T>) -> Unit
): Unit = setOnEditCancel { event -> action(event) }

/** Called when there's a request to scroll an index into view using [TreeView.scrollTo]. */
inline fun TreeView<*>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo { event -> action(event) }

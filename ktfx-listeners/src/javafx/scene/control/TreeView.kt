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
): Unit = setOnEditStart(action)

/** Sets the handler that will be called when the user commits an edit. */
inline fun <T> TreeView<T>.onEditCommit(
    noinline action: (EditEvent<T>) -> Unit
): Unit = setOnEditCommit(action)

/** Sets the handler that will be called when the user cancels an edit. */
inline fun <T> TreeView<T>.onEditCancel(
    noinline action: (EditEvent<T>) -> Unit
): Unit = setOnEditCancel(action)

/** Called when there's a request to scroll an index into view using [TreeView.scrollTo]. */
inline fun TreeView<*>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
): Unit = setOnScrollTo(action)

@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeView

inline fun <T> TreeView<T>.onEditCancel(noinline action: (TreeView.EditEvent<T>) -> Unit) = setOnEditCancel(EventHandler(action))

inline fun <T> TreeView<T>.onEditCommit(noinline action: (TreeView.EditEvent<T>) -> Unit) = setOnEditCommit(EventHandler(action))

inline fun <T> TreeView<T>.onEditStart(noinline action: (TreeView.EditEvent<T>) -> Unit) = setOnEditStart(EventHandler(action))

inline fun TreeView<*>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) = setOnScrollTo(EventHandler(action))
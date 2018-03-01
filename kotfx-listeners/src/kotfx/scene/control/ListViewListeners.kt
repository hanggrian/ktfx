@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent

inline fun <T> ListView<T>.onEditCancel(noinline action: (ListView.EditEvent<T>) -> Unit) = setOnEditCancel(EventHandler(action))

inline fun <T> ListView<T>.onEditCommit(noinline action: (ListView.EditEvent<T>) -> Unit) = setOnEditCommit(EventHandler(action))

inline fun <T> ListView<T>.onEditStart(noinline action: (ListView.EditEvent<T>) -> Unit) = setOnEditStart(EventHandler(action))

inline fun ListView<*>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) = setOnScrollTo(EventHandler(action))
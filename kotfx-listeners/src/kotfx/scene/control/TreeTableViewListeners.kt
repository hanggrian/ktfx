@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

inline fun <T> TreeTableView<T>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
) = setOnScrollTo(EventHandler(action))

inline fun <T> TreeTableView<T>.onScrollToColumn(
    noinline action: (ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) = setOnScrollToColumn(EventHandler(action))

inline fun <T> TreeTableView<T>.onSort(
    noinline action: (SortEvent<TreeTableView<T>>) -> Unit
) = setOnSort(EventHandler(action))
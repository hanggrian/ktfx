@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.event.EventHandler
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

inline fun <S> TableView<S>.onScrollTo(
    noinline action: (ScrollToEvent<Int>) -> Unit
) = setOnScrollTo(EventHandler(action))

inline fun <S> TableView<S>.onScrollToColumn(
    noinline action: (ScrollToEvent<TableColumn<S, *>>) -> Unit
) = setOnScrollToColumn(EventHandler(action))

inline fun <S> TableView<S>.onSort(
    noinline action: (SortEvent<TableView<S>>) -> Unit
) = setOnSort(EventHandler(action))
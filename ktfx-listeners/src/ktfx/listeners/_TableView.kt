@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/**
 * @see TableView.setOnSort
 */
public inline fun <S> TableView<S>.onSort(noinline action: (SortEvent<TableView<S>>) -> Unit) {
    return setOnSort(action)
}

/**
 * @see TableView.setOnScrollTo
 */
public inline fun <S> TableView<S>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) {
    return setOnScrollTo(action)
}

/**
 * @see TableView.setOnScrollToColumn
 */
public inline fun <S> TableView<S>.onScrollToColumn(
    noinline action: (ScrollToEvent<TableColumn<S, *>>) -> Unit
) {
    return setOnScrollToColumn(action)
}

@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TableView.setOnSort
 */
inline fun <S> TableView<S>.onSort(noinline action: (SortEvent<TableView<S>>) -> Unit) {
    return setOnSort(action)
}

/**
 * @see TableView.setOnScrollTo
 */
inline fun <S> TableView<S>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) {
    return setOnScrollTo(action)
}

/**
 * @see TableView.setOnScrollToColumn
 */
inline fun <S> TableView<S>.onScrollToColumn(
    noinline action: (ScrollToEvent<TableColumn<S, *>>) ->
    Unit
) {
    return setOnScrollToColumn(action)
}

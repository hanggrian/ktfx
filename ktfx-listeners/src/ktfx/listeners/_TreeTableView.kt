@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see TreeTableView.setOnSort
 */
public inline fun <T> TreeTableView<T>.onSort(
    noinline action: (SortEvent<TreeTableView<T>>) ->
    Unit
) {
    return setOnSort(action)
}

/**
 * @see TreeTableView.setOnScrollTo
 */
public inline fun <T> TreeTableView<T>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) {
    return setOnScrollTo(action)
}

/**
 * @see TreeTableView.setOnScrollToColumn
 */
public inline fun <T> TreeTableView<T>.onScrollToColumn(
    noinline
    action: (ScrollToEvent<TreeTableColumn<T, *>>) -> Unit
) {
    return setOnScrollToColumn(action)
}

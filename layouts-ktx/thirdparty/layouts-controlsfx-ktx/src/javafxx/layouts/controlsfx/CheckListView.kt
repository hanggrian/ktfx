@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ListView
import javafxx.collections.mutableObservableListOf
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.CheckListView

/** Creates a [CheckListView]. */
fun <T> checkListView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = CheckListView(items).also {
    init?.invoke(it)
}

/** Creates a [CheckListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.checkListView(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = javafxx.layouts.controlsfx.checkListView(items, init)()

/** Create a styled [ListView]. */
fun <T> styledCheckListView(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = CheckListView(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledCheckListView(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl CheckListView<T>).() -> Unit)? = null
): CheckListView<T> = javafxx.layouts.controlsfx.styledCheckListView(styleClass, items, init)()
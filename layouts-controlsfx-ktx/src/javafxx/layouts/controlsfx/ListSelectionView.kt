@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.ListSelectionView

/** Creates a [ListSelectionView]. */
fun <T> listSelectionView(
    init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ListSelectionView<T>().also {
    init?.invoke(it)
}

/** Creates a [ListSelectionView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.listSelectionView(
    noinline init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = javafxx.layouts.controlsfx.listSelectionView(init)()

/** Create a styled [ListSelectionView]. */
fun <T> styledListSelectionView(
    styleClass: String,
    init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = ListSelectionView<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ListSelectionView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledListSelectionView(
    styleClass: String,
    noinline init: ((@LayoutDsl ListSelectionView<T>).() -> Unit)? = null
): ListSelectionView<T> = javafxx.layouts.controlsfx.styledListSelectionView(styleClass, init)()
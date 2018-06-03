@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts.controlsfx

import javafx.scene.Node
import javafx.scene.control.CheckBoxTreeItem
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.CheckTreeView

/** Creates a [CheckTreeView]. */
fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = CheckTreeView<T>(root).also {
    init?.invoke(it)
}

/** Creates a [CheckTreeView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    noinline init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = ktfx.layouts.controlsfx.checkTreeView(root, init)()

/** Create a styled [CheckTreeView]. */
fun <T> styledCheckTreeView(
    styleClass: String,
    root: CheckBoxTreeItem<T>? = null,
    init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = CheckTreeView<T>(root).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [CheckTreeView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledCheckTreeView(
    styleClass: String,
    root: CheckBoxTreeItem<T>? = null,
    noinline init: ((@LayoutDsl CheckTreeView<T>).() -> Unit)? = null
): CheckTreeView<T> = ktfx.layouts.controlsfx.styledCheckTreeView(styleClass, root, init)()
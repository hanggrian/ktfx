@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTreeView
import javafx.scene.Node
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXTreeView]. */
fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    init: ((@LayoutDsl JFXTreeView<T>).() -> Unit)? = null
): JFXTreeView<T> = JFXTreeView<T>(root).also {
    init?.invoke(it)
}

/** Creates a [JFXTreeView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxTreeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl JFXTreeView<T>).() -> Unit)? = null
): JFXTreeView<T> = ktfx.jfoenix.jfxTreeView(root, init)()
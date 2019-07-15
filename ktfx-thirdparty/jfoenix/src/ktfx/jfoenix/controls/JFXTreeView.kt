@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXTreeView]. */
fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    init: ((@LayoutDslMarker JFXTreeView<T>).() -> Unit)? = null
): JFXTreeView<T> = JFXTreeView<T>(root).also { init?.invoke(it) }

/** Creates a [JFXTreeView] and add it to this manager. */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDslMarker JFXTreeView<T>).() -> Unit)? = null
): JFXTreeView<T> = ktfx.jfoenix.jfxTreeView(root, init).add()

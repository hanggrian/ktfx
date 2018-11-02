@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [JFXTreeView]. */
fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    init: ((@LayoutDsl JFXTreeView<T>).() -> Unit)? = null
): JFXTreeView<T> = JFXTreeView<T>(root).also { init?.invoke(it) }

/** Creates a [JFXTreeView] and add it to this manager. */
inline fun <T> NodeInvokable.jfxTreeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl JFXTreeView<T>).() -> Unit)? = null
): JFXTreeView<T> = ktfx.jfoenix.jfxTreeView(root, init)()
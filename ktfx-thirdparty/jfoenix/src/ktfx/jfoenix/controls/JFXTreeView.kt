@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTreeView] to this manager. */
fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null
): JFXTreeView<T> = JFXTreeView(root).add()

/** Add a [JFXTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> = jfxTreeView(root).apply(init)

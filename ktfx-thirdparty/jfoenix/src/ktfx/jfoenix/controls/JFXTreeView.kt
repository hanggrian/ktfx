@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTreeView] with initialization block. */
inline fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> = JFXTreeView(root).apply(init)

/** Add a [JFXTreeView] to this manager. */
fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null
): JFXTreeView<T> = addNode(ktfx.jfoenix.jfxTreeView(root) { })

/** Add a [JFXTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> = addNode(ktfx.jfoenix.jfxTreeView(root, init))
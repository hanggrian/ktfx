@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTreeView] with initialization block. */
inline fun <T> jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> = JFXTreeView(root).apply(init)

/** Add a [JFXTreeView] to this manager. */
fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null
): JFXTreeView<T> = addNode(JFXTreeView(root))

/** Add a [JFXTreeView] with initialization block to this manager. */
inline fun <T> NodeManager.jfxTreeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker JFXTreeView<T>).() -> Unit
): JFXTreeView<T> = addNode(JFXTreeView(root), init)

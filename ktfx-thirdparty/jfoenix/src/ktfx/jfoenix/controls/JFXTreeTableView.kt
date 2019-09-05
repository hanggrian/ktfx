@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTreeTableView] to this manager. */
fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null
): JFXTreeTableView<S> = JFXTreeTableView(root).add()

/** Add a [JFXTreeTableView] with initialization block to this manager. */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> = jfxTreeTableView(root).apply(init)

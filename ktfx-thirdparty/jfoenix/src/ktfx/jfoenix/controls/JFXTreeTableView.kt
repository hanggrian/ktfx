@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXTreeTableView]. */
fun <S : RecursiveTreeObject<S>> jfxTreeTableView(
    root: TreeItem<S>? = null,
    init: ((@LayoutMarker JFXTreeTableView<S>).() -> Unit)? = null
): JFXTreeTableView<S> = JFXTreeTableView<S>(root).also { init?.invoke(it) }

/** Creates a [JFXTreeTableView] and add it to this manager. */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    noinline init: ((@LayoutMarker JFXTreeTableView<S>).() -> Unit)? = null
): JFXTreeTableView<S> = ktfx.jfoenix.jfxTreeTableView(root, init).add()
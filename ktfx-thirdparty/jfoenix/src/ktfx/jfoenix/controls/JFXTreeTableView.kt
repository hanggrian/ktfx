@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXTreeTableView]. */
fun <S : RecursiveTreeObject<S>> jfxTreeTableView(
    root: TreeItem<S>? = null,
    init: ((@LayoutDslMarker JFXTreeTableView<S>).() -> Unit)? = null
): JFXTreeTableView<S> = JFXTreeTableView<S>(root).also { init?.invoke(it) }

/** Creates a [JFXTreeTableView] and add it to this manager. */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    noinline init: ((@LayoutDslMarker JFXTreeTableView<S>).() -> Unit)? = null
): JFXTreeTableView<S> = ktfx.jfoenix.jfxTreeTableView(root, init).add()

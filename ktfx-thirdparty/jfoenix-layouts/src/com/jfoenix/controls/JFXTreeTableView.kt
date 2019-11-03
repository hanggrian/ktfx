@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTreeTableView] with initialization block. */
inline fun <S : RecursiveTreeObject<S>> jfxTreeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> = JFXTreeTableView(root).apply(init)

/** Add a [JFXTreeTableView] to this manager. */
fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null
): JFXTreeTableView<S> = addNode(JFXTreeTableView(root))

/** Add a [JFXTreeTableView] with initialization block to this manager. */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> = addNode(JFXTreeTableView(root), init)

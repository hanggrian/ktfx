@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTreeTableView] with initialization block. */
inline fun <S : RecursiveTreeObject<S>> jfxTreeTableView(
    root: TreeItem<S>? = null,
    configuration: (@LayoutsDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTreeTableView(root).apply(configuration)
}

/** Add a [JFXTreeTableView] to this manager. */
fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null
): JFXTreeTableView<S> = addChild(JFXTreeTableView(root))

/** Add a [JFXTreeTableView] with initialization block to this manager. */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    configuration: (@LayoutsDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTreeTableView(root), configuration)
}
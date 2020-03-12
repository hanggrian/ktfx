@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXTreeTableView] to this manager.
 */
fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(root: TreeItem<S>? = null):
        JFXTreeTableView<S> = jfxTreeTableView(root = root) { }

/**
 * Create a [JFXTreeTableView] with configuration block.
 */
inline fun <S : RecursiveTreeObject<S>> jfxTreeTableView(
    root: TreeItem<S>? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXTreeTableView<S>(root), configuration = configuration)
}

/**
 * Add a [JFXTreeTableView] with configuration block to this manager.
 */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXTreeTableView<S>(root), configuration = configuration))
}

/**
 * Create a styled [JFXTreeTableView].
 */
fun <S : RecursiveTreeObject<S>> styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeTableView<S> = styledJFXTreeTableView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTreeTableView] to this manager.
 */
fun <S : RecursiveTreeObject<S>> NodeManager.styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeTableView<S> = styledJFXTreeTableView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTreeTableView] with configuration block.
 */
inline fun <S : RecursiveTreeObject<S>> styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXTreeTableView<S>(root), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXTreeTableView] with configuration block to this manager.
 */
inline fun <S : RecursiveTreeObject<S>> NodeManager.styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXTreeTableView<S>(root), styleClass = *styleClass, id = id,
            configuration = configuration))
}

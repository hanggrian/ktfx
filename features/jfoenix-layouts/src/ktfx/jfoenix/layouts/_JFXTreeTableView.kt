@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXTreeTableView] to this manager.
 *
 * @return the control added.
 */
fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(root: TreeItem<S>? = null):
    JFXTreeTableView<S> = jfxTreeTableView(root = root) { }

/**
 * Create a [JFXTreeTableView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun <S : RecursiveTreeObject<S>> jfxTreeTableView(
    root: TreeItem<S>? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.configuration()
    return child
}

/**
 * Add a [JFXTreeTableView] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun <S : RecursiveTreeObject<S>> NodeManager.jfxTreeTableView(
    root: TreeItem<S>? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTreeTableView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun <S : RecursiveTreeObject<S>> styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeTableView<S> = styledJFXTreeTableView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTreeTableView] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun <S : RecursiveTreeObject<S>> NodeManager.styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTreeTableView<S> = styledJFXTreeTableView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTreeTableView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun <S : RecursiveTreeObject<S>> styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTreeTableView] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun <S : RecursiveTreeObject<S>> NodeManager.styledJFXTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTreeTableView<S>).() -> Unit
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

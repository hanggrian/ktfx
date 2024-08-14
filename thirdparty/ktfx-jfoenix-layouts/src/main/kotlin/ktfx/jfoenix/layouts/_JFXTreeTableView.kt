@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeTableView
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.scene.control.TreeItem
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXTreeTableView] to this container.
 *
 * @return the control added.
 */
public inline fun <S : RecursiveTreeObject<S>> NodeContainer.jfxTreeTableView(root: TreeItem<S>? =
        null): JFXTreeTableView<S> = jfxTreeTableView(root = root) { }

/**
 * Create a [JFXTreeTableView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun <S : RecursiveTreeObject<S>> jfxTreeTableView(root: TreeItem<S>? = null,
        configuration: (@KtfxLayoutDslMarker JFXTreeTableView<S>).() -> Unit): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.configuration()
    return child
}

/**
 * Add a [JFXTreeTableView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun <S : RecursiveTreeObject<S>> NodeContainer.jfxTreeTableView(root: TreeItem<S>? = null,
        configuration: (@KtfxLayoutDslMarker JFXTreeTableView<S>).() -> Unit): JFXTreeTableView<S> {
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
public inline fun <S : RecursiveTreeObject<S>> styledJfxTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTreeTableView<S> = styledJfxTreeTableView(root = root, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXTreeTableView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <S : RecursiveTreeObject<S>> NodeContainer.styledJfxTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTreeTableView<S> = styledJfxTreeTableView(root = root, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXTreeTableView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun <S : RecursiveTreeObject<S>> styledJfxTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeTableView<S>).() -> Unit,
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTreeTableView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun <S : RecursiveTreeObject<S>> NodeContainer.styledJfxTreeTableView(
    root: TreeItem<S>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeTableView<S>).() -> Unit,
): JFXTreeTableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeTableView<S>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

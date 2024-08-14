@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
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
 * Add a [JFXTreeView] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxTreeView(root: TreeItem<T>? = null): JFXTreeView<T> =
        jfxTreeView(root = root) { }

/**
 * Create a [JFXTreeView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun <T> jfxTreeView(root: TreeItem<T>? = null, configuration: (@KtfxLayoutDslMarker
        JFXTreeView<T>).() -> Unit): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.configuration()
    return child
}

/**
 * Add a [JFXTreeView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.jfxTreeView(root: TreeItem<T>? = null,
        configuration: (@KtfxLayoutDslMarker JFXTreeView<T>).() -> Unit): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXTreeView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <T> styledJfxTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTreeView<T> = styledJfxTreeView(root = root, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXTreeView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJfxTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXTreeView<T> = styledJfxTreeView(root = root, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXTreeView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun <T> styledJfxTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeView<T>).() -> Unit,
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXTreeView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledJfxTreeView(
    root: TreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXTreeView<T>).() -> Unit,
): JFXTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXTreeView<T>(root)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

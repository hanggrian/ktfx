@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CustomMenuItem] to this container.
 *
 * @return the control added.
 */
public fun MenuItemContainer.customMenuItem(content: Node? = null, hideOnClick: Boolean = true):
        CustomMenuItem = customMenuItem(content = content, hideOnClick = hideOnClick) { }

/**
 * Create a [CustomMenuItem] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    configuration: (@KtfxLayoutDslMarker CustomMenuItem).() -> Unit,
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomMenuItem(content, hideOnClick)
    child.configuration()
    return child
}

/**
 * Add a [CustomMenuItem] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun MenuItemContainer.customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    configuration: (@KtfxLayoutDslMarker CustomMenuItem).() -> Unit,
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomMenuItem(content, hideOnClick)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CustomMenuItem].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
): CustomMenuItem = styledCustomMenuItem(content = content, hideOnClick = hideOnClick, styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [CustomMenuItem] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun MenuItemContainer.styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
): CustomMenuItem = styledCustomMenuItem(content = content, hideOnClick = hideOnClick, styleClass =
        *styleClass, id = id) { }

/**
 * Create a styled [CustomMenuItem] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CustomMenuItem).() -> Unit,
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomMenuItem(content, hideOnClick)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CustomMenuItem] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledCustomMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CustomMenuItem).() -> Unit,
): CustomMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CustomMenuItem(content, hideOnClick)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MenuItem] to this container.
 *
 * @return the control added.
 */
public fun MenuItemContainer.menuItem(text: String? = null, graphic: Node? = null): MenuItem =
        menuItem(text = text, graphic = graphic) { }

/**
 * Create a [MenuItem] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MenuItem(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [MenuItem] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun MenuItemContainer.menuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MenuItem(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [MenuItem].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): MenuItem = styledMenuItem(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MenuItem] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun MenuItemContainer.styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): MenuItem = styledMenuItem(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MenuItem] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MenuItem(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MenuItem] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MenuItem(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SeparatorMenuItem] to this container.
 *
 * @return the control added.
 */
public fun MenuItemContainer.separatorMenuItem(): SeparatorMenuItem = separatorMenuItem() { }

/**
 * Create a [SeparatorMenuItem] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun separatorMenuItem(configuration: (@KtfxLayoutDslMarker
        SeparatorMenuItem).() -> Unit): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SeparatorMenuItem()
    child.configuration()
    return child
}

/**
 * Add a [SeparatorMenuItem] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun MenuItemContainer.separatorMenuItem(configuration: (@KtfxLayoutDslMarker
        SeparatorMenuItem).() -> Unit): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SeparatorMenuItem()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SeparatorMenuItem].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledSeparatorMenuItem(vararg styleClass: String, id: String? = null): SeparatorMenuItem
        = styledSeparatorMenuItem(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SeparatorMenuItem] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun MenuItemContainer.styledSeparatorMenuItem(vararg styleClass: String, id: String? = null):
        SeparatorMenuItem = styledSeparatorMenuItem(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SeparatorMenuItem] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledSeparatorMenuItem(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker SeparatorMenuItem).() -> Unit,
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SeparatorMenuItem()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SeparatorMenuItem] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledSeparatorMenuItem(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker SeparatorMenuItem).() -> Unit,
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SeparatorMenuItem()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

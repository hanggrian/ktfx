@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MenuButton] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.menuButton(text: String? = null, graphic: Node? = null): MenuButton
        = menuButton(text = text, graphic = graphic) { }

/**
 * Create a [MenuButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenuButton).() -> Unit,
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [MenuButton] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenuButton).() -> Unit,
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [MenuButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = styleClass, id = id) {
        }

/**
 * Add a styled [MenuButton] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = styleClass, id = id) {
        }

/**
 * Create a styled [MenuButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenuButton).() -> Unit,
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MenuButton] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenuButton).() -> Unit,
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

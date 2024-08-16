@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Menu] to this container.
 *
 * @return the control added.
 */
public inline fun MenuItemContainer.menu(text: String = "", graphic: Node? = null): Menu = menu(text
        = text, graphic = graphic) { }

/**
 * Add a [Menu] to this container.
 *
 * @return the control added.
 */
public inline fun MenuContainer.menu(text: String = "", graphic: Node? = null): Menu = menu(text =
        text, graphic = graphic) { }

/**
 * Create a [Menu] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenu(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [Menu] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun MenuItemContainer.menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenu(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [Menu] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun MenuContainer.menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenu(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Menu].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Menu = styledMenu(text = text, graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Menu] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Menu = styledMenu(text = text, graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Menu] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun MenuContainer.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Menu = styledMenu(text = text, graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Menu] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenu(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Menu] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenu(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [Menu] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun MenuContainer.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenu(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CheckMenuItem] to this container.
 *
 * @return the control added.
 */
public inline fun MenuItemContainer.checkMenuItem(text: String? = null, graphic: Node? = null):
        CheckMenuItem = checkMenuItem(text = text, graphic = graphic) { }

/**
 * Create a [CheckMenuItem] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker CheckMenuItem).() -> Unit,
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckMenuItem(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [CheckMenuItem] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun MenuItemContainer.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker CheckMenuItem).() -> Unit,
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckMenuItem(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [CheckMenuItem].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): CheckMenuItem = styledCheckMenuItem(text = text, graphic = graphic, styleClass = styleClass, id =
        id) { }

/**
 * Add a styled [CheckMenuItem] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): CheckMenuItem = styledCheckMenuItem(text = text, graphic = graphic, styleClass = styleClass, id =
        id) { }

/**
 * Create a styled [CheckMenuItem] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckMenuItem).() -> Unit,
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckMenuItem(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [CheckMenuItem] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun MenuItemContainer.styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker CheckMenuItem).() -> Unit,
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = CheckMenuItem(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

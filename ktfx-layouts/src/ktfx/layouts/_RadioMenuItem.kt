@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioMenuItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [RadioMenuItem] to this manager.
 *
 * @return the control added.
 */
fun MenuItemManager.radioMenuItem(text: String? = null, graphic: Node? = null): RadioMenuItem =
    radioMenuItem(text = text, graphic = graphic) { }

/**
 * Create a [RadioMenuItem] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioMenuItem(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [RadioMenuItem] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun MenuItemManager.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioMenuItem(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [RadioMenuItem].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): RadioMenuItem = styledRadioMenuItem(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [RadioMenuItem] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun MenuItemManager.styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): RadioMenuItem = styledRadioMenuItem(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [RadioMenuItem] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioMenuItem(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [RadioMenuItem] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun MenuItemManager.styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioMenuItem(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

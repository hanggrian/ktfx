@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MenuButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.menuButton(text: String? = null, graphic: Node? = null): MenuButton =
    menuButton(text = text, graphic = graphic) { }

/**
 * Create a [MenuButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [MenuButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
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
fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MenuButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MenuButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MenuButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuButton(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

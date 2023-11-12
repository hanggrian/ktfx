@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Button] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.button(text: String? = null, graphic: Node? = null): Button = button(text =
        text, graphic = graphic) { }

/**
 * Create a [Button] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun button(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker Button).() -> Unit,
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Button(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [Button] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.button(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker Button).() -> Unit,
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Button(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Button].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Button = styledButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Button] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Button = styledButton(text = text, graphic = graphic, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Button] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Button).() -> Unit,
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Button(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Button] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Button).() -> Unit,
): Button {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Button(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

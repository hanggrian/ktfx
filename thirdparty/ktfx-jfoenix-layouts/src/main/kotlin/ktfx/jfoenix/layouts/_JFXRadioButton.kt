@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
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
import ktfx.layouts.ToggleButtonContainer

/**
 * Add a [JFXRadioButton] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxRadioButton(text: String? = null): JFXRadioButton =
        jfxRadioButton(text = text) { }

/**
 * Add a [JFXRadioButton] to this container.
 *
 * @return the control added.
 */
public inline fun ToggleButtonContainer.jfxRadioButton(text: String? = null): JFXRadioButton =
        jfxRadioButton(text = text) { }

/**
 * Create a [JFXRadioButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun jfxRadioButton(text: String? = null, configuration: (@KtfxLayoutDslMarker
        JFXRadioButton).() -> Unit): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXRadioButton] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxRadioButton(text: String? = null, configuration: (@KtfxLayoutDslMarker
        JFXRadioButton).() -> Unit): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [JFXRadioButton] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun ToggleButtonContainer.jfxRadioButton(text: String? = null,
        configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXRadioButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXRadioButton = styledJfxRadioButton(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXRadioButton] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXRadioButton = styledJfxRadioButton(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXRadioButton] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonContainer.styledJfxRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXRadioButton = styledJfxRadioButton(text = text, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXRadioButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledJfxRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit,
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXRadioButton] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJfxRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit,
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [JFXRadioButton] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun ToggleButtonContainer.styledJfxRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit,
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

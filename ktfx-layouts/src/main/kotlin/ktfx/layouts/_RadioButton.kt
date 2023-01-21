@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.RadioButton
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
 * Add a [RadioButton] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.radioButton(text: String? = null): RadioButton = radioButton(text = text) { }

/**
 * Add a [RadioButton] to this manager.
 *
 * @return the control added.
 */
public fun ToggleButtonManager.radioButton(text: String? = null): RadioButton = radioButton(text =
        text) { }

/**
 * Create a [RadioButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun radioButton(text: String? = null, configuration: (@KtfxLayoutDslMarker
        RadioButton).() -> Unit): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioButton(text)
    child.configuration()
    return child
}

/**
 * Add a [RadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.radioButton(text: String? = null, configuration: (@KtfxLayoutDslMarker
        RadioButton).() -> Unit): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioButton(text)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [RadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun ToggleButtonManager.radioButton(text: String? = null,
        configuration: (@KtfxLayoutDslMarker RadioButton).() -> Unit): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioButton(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [RadioButton].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): RadioButton = styledRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [RadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): RadioButton = styledRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [RadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun ToggleButtonManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): RadioButton = styledRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [RadioButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker RadioButton).() -> Unit,
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [RadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker RadioButton).() -> Unit,
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [RadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonManager.styledRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker RadioButton).() -> Unit,
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = RadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

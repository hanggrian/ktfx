@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXRadioButton] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.jfxRadioButton(text: String? = null): JFXRadioButton = jfxRadioButton(
    text =
    text
) { }

/**
 * Add a [JFXRadioButton] to this manager.
 *
 * @return the control added.
 */
public fun ToggleButtonManager.jfxRadioButton(text: String? = null): JFXRadioButton =
    jfxRadioButton(text = text) { }

/**
 * Create a [JFXRadioButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxRadioButton(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        JFXRadioButton
    ).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.configuration()
    return child
}

/**
 * Add a [JFXRadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [JFXRadioButton] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun ToggleButtonManager.jfxRadioButton(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
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
public fun styledJFXRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXRadioButton = styledJFXRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledJFXRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXRadioButton = styledJFXRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRadioButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun ToggleButtonManager.styledJFXRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXRadioButton = styledJFXRadioButton(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXRadioButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXRadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledJFXRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [JFXRadioButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonManager.styledJFXRadioButton(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXRadioButton(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

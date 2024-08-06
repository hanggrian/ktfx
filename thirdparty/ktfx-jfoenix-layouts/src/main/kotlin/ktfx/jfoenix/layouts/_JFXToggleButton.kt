@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
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
 * Add a [JFXToggleButton] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxToggleButton(): JFXToggleButton = jfxToggleButton() { }

/**
 * Add a [JFXToggleButton] to this container.
 *
 * @return the control added.
 */
public fun ToggleButtonContainer.jfxToggleButton(): JFXToggleButton = jfxToggleButton() { }

/**
 * Create a [JFXToggleButton] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun jfxToggleButton(configuration: (@KtfxLayoutDslMarker JFXToggleButton).() -> Unit):
        JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleButton()
    child.configuration()
    return child
}

/**
 * Add a [JFXToggleButton] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.jfxToggleButton(configuration: (@KtfxLayoutDslMarker
        JFXToggleButton).() -> Unit): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleButton()
    child.configuration()
    return addChild(child)
}

/**
 * Add a [JFXToggleButton] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun ToggleButtonContainer.jfxToggleButton(configuration: (@KtfxLayoutDslMarker
        JFXToggleButton).() -> Unit): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleButton()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXToggleButton].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledJFXToggleButton(vararg styleClass: String, id: String? = null): JFXToggleButton =
        styledJFXToggleButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToggleButton] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXToggleButton(vararg styleClass: String, id: String? = null):
        JFXToggleButton = styledJFXToggleButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToggleButton] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun ToggleButtonContainer.styledJFXToggleButton(vararg styleClass: String, id: String? =
        null): JFXToggleButton = styledJFXToggleButton(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXToggleButton] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledJFXToggleButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXToggleButton).() -> Unit,
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXToggleButton] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXToggleButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXToggleButton).() -> Unit,
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [JFXToggleButton] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun ToggleButtonContainer.styledJFXToggleButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXToggleButton).() -> Unit,
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

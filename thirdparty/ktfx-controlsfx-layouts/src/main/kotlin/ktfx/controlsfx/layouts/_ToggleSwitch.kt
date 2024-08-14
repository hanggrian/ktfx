@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

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
import org.controlsfx.control.ToggleSwitch

/**
 * Add a [ToggleSwitch] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.toggleSwitch(text: String? = null): ToggleSwitch = toggleSwitch(text
        = text) { }

/**
 * Create a [ToggleSwitch] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun toggleSwitch(text: String? = null, configuration: (@KtfxLayoutDslMarker
        ToggleSwitch).() -> Unit): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.configuration()
    return child
}

/**
 * Add a [ToggleSwitch] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.toggleSwitch(text: String? = null, configuration: (@KtfxLayoutDslMarker
        ToggleSwitch).() -> Unit): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ToggleSwitch].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): ToggleSwitch = styledToggleSwitch(text = text, styleClass = styleClass, id = id) { }

/**
 * Add a styled [ToggleSwitch] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
): ToggleSwitch = styledToggleSwitch(text = text, styleClass = styleClass, id = id) { }

/**
 * Create a styled [ToggleSwitch] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleSwitch).() -> Unit,
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ToggleSwitch] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleSwitch).() -> Unit,
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ToggleSwitch
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ToggleSwitch] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.toggleSwitch(text: String? = null): ToggleSwitch = toggleSwitch(text = text) { }

/**
 * Create a [ToggleSwitch] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun toggleSwitch(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        ToggleSwitch
    ).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.configuration()
    return child
}

/**
 * Add a [ToggleSwitch] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    configuration: (
        @KtfxLayoutDslMarker    
        ToggleSwitch
    ).() -> Unit
): ToggleSwitch {
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
fun styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleSwitch = styledToggleSwitch(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ToggleSwitch] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleSwitch = styledToggleSwitch(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ToggleSwitch] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ToggleSwitch] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ToggleSwitch(text)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

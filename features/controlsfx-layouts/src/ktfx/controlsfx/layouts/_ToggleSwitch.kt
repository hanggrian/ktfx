@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
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
 */
fun NodeManager.toggleSwitch(text: String? = null): ToggleSwitch = toggleSwitch(text = text) { }

/**
 * Create a [ToggleSwitch] with configuration block.
 */
inline fun toggleSwitch(
    text: String? = null,
    configuration: (@LayoutDslMarker ToggleSwitch).() ->    
    Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ToggleSwitch(text), configuration = configuration)
}

/**
 * Add a [ToggleSwitch] with configuration block to this manager.
 */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    configuration: (
        @LayoutDslMarker    
        ToggleSwitch
    ).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleSwitch(text), configuration = configuration))
}

/**
 * Create a styled [ToggleSwitch].
 */
fun styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleSwitch = styledToggleSwitch(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ToggleSwitch] to this manager.
 */
fun NodeManager.styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleSwitch = styledToggleSwitch(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ToggleSwitch] with configuration block.
 */
inline fun styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ToggleSwitch(text), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ToggleSwitch] with configuration block to this manager.
 */
inline fun NodeManager.styledToggleSwitch(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ToggleSwitch(text), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

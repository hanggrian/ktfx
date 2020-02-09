@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.ToggleSwitch

/** Create a [ToggleSwitch] with configurationialization block. */
inline fun toggleSwitch(
    text: String? = null,
    configuration: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ToggleSwitch(text).apply(configuration)
}

/** Add a [ToggleSwitch] to this manager. */
fun NodeManager.toggleSwitch(
    text: String? = null
): ToggleSwitch = addChild(ToggleSwitch(text))

/** Add a [ToggleSwitch] with configurationialization block to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    configuration: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ToggleSwitch(text), configuration)
}

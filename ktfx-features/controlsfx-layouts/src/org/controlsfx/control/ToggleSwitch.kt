@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.ToggleSwitch

/** Create a [ToggleSwitch] with initialization block. */
inline fun toggleSwitch(
    text: String? = null,
    init: (@LayoutsDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ToggleSwitch(text).apply(init)
}

/** Add a [ToggleSwitch] to this manager. */
fun NodeManager.toggleSwitch(
    text: String? = null
): ToggleSwitch = addNode(ToggleSwitch(text))

/** Add a [ToggleSwitch] with initialization block to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    init: (@LayoutsDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ToggleSwitch(text), init)
}

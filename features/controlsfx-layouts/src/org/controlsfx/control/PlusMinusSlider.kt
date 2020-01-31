@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.PlusMinusSlider

/** Create a [PlusMinusSlider] with initialization block. */
inline fun plusMinusSlider(
    configuration: (@LayoutsDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PlusMinusSlider().apply(configuration)
}

/** Add a [PlusMinusSlider] to this manager. */
fun NodeManager.plusMinusSlider(): PlusMinusSlider =
    addChild(PlusMinusSlider())

/** Add a [PlusMinusSlider] with initialization block to this manager. */
inline fun NodeManager.plusMinusSlider(
    configuration: (@LayoutsDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(PlusMinusSlider(), configuration)
}
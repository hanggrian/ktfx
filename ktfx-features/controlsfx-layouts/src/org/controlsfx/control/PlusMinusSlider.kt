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
import org.controlsfx.control.PlusMinusSlider

/** Create a [PlusMinusSlider] with initialization block. */
inline fun plusMinusSlider(
    init: (@LayoutsDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return PlusMinusSlider().apply(init)
}

/** Add a [PlusMinusSlider] to this manager. */
fun NodeManager.plusMinusSlider(): PlusMinusSlider =
    addNode(PlusMinusSlider())

/** Add a [PlusMinusSlider] with initialization block to this manager. */
inline fun NodeManager.plusMinusSlider(
    init: (@LayoutsDslMarker PlusMinusSlider).() -> Unit
): PlusMinusSlider {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(PlusMinusSlider(), init)
}

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Create a [PrefixSelectionChoiceBox] with initialization block. */
inline fun <T> prefixSelectionChoiceBox(
    init: PrefixSelectionChoiceBox<T>.() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return PrefixSelectionChoiceBox<T>().apply(init)
}
/** Add a [PrefixSelectionChoiceBox] to this manager. */
fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> =
    addNode(PrefixSelectionChoiceBox())

/** Add a [PrefixSelectionChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    init: PrefixSelectionChoiceBox<T>.() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(PrefixSelectionChoiceBox(), init)
}

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
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Create a [PrefixSelectionChoiceBox] with initialization block. */
inline fun <T> prefixSelectionChoiceBox(
    configuration: (@LayoutsDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PrefixSelectionChoiceBox<T>().apply(configuration)
}

/** Add a [PrefixSelectionChoiceBox] to this manager. */
fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> = addChild(PrefixSelectionChoiceBox())

/** Add a [PrefixSelectionChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    configuration: (@LayoutsDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(PrefixSelectionChoiceBox(), configuration)
}

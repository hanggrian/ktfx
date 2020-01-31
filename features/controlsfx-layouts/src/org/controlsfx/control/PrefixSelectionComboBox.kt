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
import org.controlsfx.control.PrefixSelectionComboBox

/** Create a [PrefixSelectionComboBox] with initialization block. */
inline fun <T> prefixSelectionComboBox(
    configuration: (@LayoutsDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PrefixSelectionComboBox<T>().apply(configuration)
}

/** Add a [PrefixSelectionComboBox] to this manager. */
fun <T> NodeManager.prefixSelectionComboBox(): PrefixSelectionComboBox<T> = addChild(PrefixSelectionComboBox())

/** Add a [PrefixSelectionComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionComboBox(
    configuration: (@LayoutsDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(PrefixSelectionComboBox(), configuration)
}
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
    init: (@LayoutsDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return PrefixSelectionComboBox<T>().apply(init)
}

/** Add a [PrefixSelectionComboBox] to this manager. */
fun <T> NodeManager.prefixSelectionComboBox(): PrefixSelectionComboBox<T> = addChild(PrefixSelectionComboBox())

/** Add a [PrefixSelectionComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionComboBox(
    init: (@LayoutsDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(PrefixSelectionComboBox(), init)
}

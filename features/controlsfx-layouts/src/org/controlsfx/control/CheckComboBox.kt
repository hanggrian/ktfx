@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.CheckComboBox

/** Create a [CheckComboBox] with initialization block. */
inline fun <T> checkComboBox(
    items: ObservableList<T>? = null,
    init: (@LayoutsDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CheckComboBox(items).apply(init)
}

/** Add a [CheckComboBox] to this manager. */
fun <T> NodeManager.checkComboBox(
    items: ObservableList<T>? = null
): CheckComboBox<T> = addChild(CheckComboBox(items))

/** Add a [CheckComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T>? = null,
    init: (@LayoutsDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(CheckComboBox(items), init)
}

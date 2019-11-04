@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.CheckComboBox

/** Create a [CheckComboBox] with initialization block. */
inline fun <T> checkComboBox(
    items: ObservableList<T>? = null,
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return CheckComboBox(items).apply(init)
}

/** Add a [CheckComboBox] to this manager. */
fun <T> NodeManager.checkComboBox(
    items: ObservableList<T>? = null
): CheckComboBox<T> = addNode(CheckComboBox(items))

/** Add a [CheckComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T>? = null,
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(CheckComboBox(items), init)
}

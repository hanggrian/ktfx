@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ComboBox] with initialization block. */
inline fun <T> comboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ComboBox<T>.() -> Unit
): ComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ComboBox(items).apply(init)
}
/** Add a [ComboBox] to this manager. */
fun <T> NodeManager.comboBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): ComboBox<T> = addNode(ComboBox(items))

/** Add a [ComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.comboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ComboBox<T>.() -> Unit
): ComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ComboBox(items), init)
}

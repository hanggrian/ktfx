@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXComboBox
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXComboBox] with initialization block. */
inline fun <T> jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: JFXComboBox<T>.() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXComboBox(items).apply(init)
}

/** Add a [JFXComboBox] to this manager. */
fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): JFXComboBox<T> = addNode(JFXComboBox(items))

/** Add a [JFXComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: JFXComboBox<T>.() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXComboBox(items), init)
}

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
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXComboBox] with configuration block. */
inline fun <T> jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXComboBox(items).apply(configuration)
}

/** Add a [JFXComboBox] to this manager. */
fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): JFXComboBox<T> = addChild(JFXComboBox(items))

/** Add a [JFXComboBox] with configuration block to this manager. */
inline fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXComboBox(items), configuration)
}

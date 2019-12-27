@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ChoiceBox] with initialization block. */
inline fun <T> choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutsDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ChoiceBox(items).apply(configuration)
}

/** Add a [ChoiceBox] to this manager. */
fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): ChoiceBox<T> = addChild(ChoiceBox(items))

/** Add a [ChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    configuration: (@LayoutsDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ChoiceBox(items), configuration)
}

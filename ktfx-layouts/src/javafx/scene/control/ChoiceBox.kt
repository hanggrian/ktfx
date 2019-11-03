@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox

/** Create a [ChoiceBox] with initialization block. */
inline fun <T> choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = ChoiceBox(items).apply(init)

/** Add a [ChoiceBox] to this manager. */
fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): ChoiceBox<T> = addNode(ChoiceBox(items))

/** Add a [ChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = addNode(ChoiceBox(items), init)

@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

/** Create a [ChoiceBox] with initialization block. */
inline fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = ChoiceBox(items).apply(init)

/** Add a [ChoiceBox] to this manager. */
fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = mutableObservableListOf()
): ChoiceBox<T> = addNode(ChoiceBox(items))

/** Add a [ChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = addNode(ChoiceBox(items), init)

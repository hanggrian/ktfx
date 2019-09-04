@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

/** Add a [ChoiceBox] to this manager. */
fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = mutableObservableListOf()
): ChoiceBox<T> = ChoiceBox(items).add()

/** Add a [ChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = choiceBox(items).apply(init)

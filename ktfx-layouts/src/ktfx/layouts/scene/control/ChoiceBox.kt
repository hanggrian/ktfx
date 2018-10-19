@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [ChoiceBox]. */
fun <T> choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also { init?.invoke(it) }

/** Creates a [ChoiceBox] and add it to this manager. */
inline fun <T> NodeManager.choiceBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init)()
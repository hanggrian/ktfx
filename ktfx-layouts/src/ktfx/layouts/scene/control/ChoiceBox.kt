@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

/** Creates a [ChoiceBox]. */
fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also { init?.invoke(it) }

/** Creates a [ChoiceBox] and add it to this manager. */
inline fun <T> NodeInvokable.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init)()
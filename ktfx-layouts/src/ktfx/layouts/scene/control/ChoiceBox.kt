@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

inline fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also { init?.invoke(it) }

inline fun <T> LayoutManager<Node>.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
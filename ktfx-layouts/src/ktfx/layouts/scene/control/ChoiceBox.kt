@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

inline fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf()
): ChoiceBox<T> = choiceBox(items) { }

inline fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDsl ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = ChoiceBox(items).apply(init)

inline fun <T> LayoutManager<Node>.choiceBox(
    items: ObservableList<T> = mutableObservableListOf()
): ChoiceBox<T> = choiceBox(items) { }

inline fun <T> LayoutManager<Node>.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDsl ChoiceBox<T>).() -> Unit
): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
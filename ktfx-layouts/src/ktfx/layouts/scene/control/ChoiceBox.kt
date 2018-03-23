@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import ktfx.collections.mutableObservableListOf

inline fun <T> choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
inline fun <T> ItemManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
inline fun <T> ButtonManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ktfx.layouts.choiceBox(items, init).add()
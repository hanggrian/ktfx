@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ChoiceBox
import javafxx.collections.mutableObservableListOf

/** Creates a [ChoiceBox]. */
fun <T> choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also {
    init?.invoke(it)
}

/** Creates a [ChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.choiceBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = javafxx.layouts.choiceBox(items, init)()

/** Create a styled [ChoiceBox]. */
fun <T> styledChoiceBox(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledChoiceBox(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = javafxx.layouts.styledChoiceBox(styleClass, items, init)()
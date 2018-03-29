@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ComboBox
import ktfx.collections.mutableObservableListOf

inline fun <T> comboBox(
    items: ObservableList<T> = mutableObservableListOf()
): ComboBox<T> = comboBox(items) { }

inline fun <T> comboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDsl ComboBox<T>).() -> Unit
): ComboBox<T> = ComboBox(items).apply(init)

inline fun <T> LayoutManager<Node>.comboBox(
    items: ObservableList<T> = mutableObservableListOf()
): ComboBox<T> = comboBox(items) { }

inline fun <T> LayoutManager<Node>.comboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDsl ComboBox<T>).() -> Unit
): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()
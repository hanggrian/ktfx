@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ListView
import ktfx.collections.mutableObservableListOf

inline fun <T> listView(
    items: ObservableList<T> = mutableObservableListOf()
): ListView<T> = listView(items) { }

inline fun <T> listView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDsl ListView<T>).() -> Unit
): ListView<T> = ListView(items).apply(init)

inline fun <T> LayoutManager<Node>.listView(
    items: ObservableList<T> = mutableObservableListOf()
): ListView<T> = listView(items) { }

inline fun <T> LayoutManager<Node>.listView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDsl ListView<T>).() -> Unit
): ListView<T> = ktfx.layouts.listView(items, init).add()
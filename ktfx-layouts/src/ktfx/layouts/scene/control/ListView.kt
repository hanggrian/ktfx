@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ListView
import ktfx.collections.mutableObservableListOf

inline fun <T> listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }

inline fun <T> Manager<Node>.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()
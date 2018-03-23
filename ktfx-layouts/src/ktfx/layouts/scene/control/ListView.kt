@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import ktfx.collections.mutableObservableListOf

inline fun <T> listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()
inline fun <T> ItemManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()
inline fun <T> ButtonManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null): ListView<T> = ktfx.layouts.listView(items, init).add()
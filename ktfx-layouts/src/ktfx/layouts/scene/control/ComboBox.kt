@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import ktfx.collections.mutableObservableListOf

inline fun <T> comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()
inline fun <T> ItemManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()
inline fun <T> ButtonManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@LayoutDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ktfx.layouts.comboBox(items, init).add()
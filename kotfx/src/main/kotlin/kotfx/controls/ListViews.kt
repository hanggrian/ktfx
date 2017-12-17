@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import kotfx.internal.ChildManager
import kotfx.internal.KotfxDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun <T> listViewOf(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()
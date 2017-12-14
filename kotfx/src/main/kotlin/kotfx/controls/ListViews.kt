@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import kotfx.ChildManager
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun <T> listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()
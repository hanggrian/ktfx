@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import kotfx.ChildManager
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun <T> comboBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.comboBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()
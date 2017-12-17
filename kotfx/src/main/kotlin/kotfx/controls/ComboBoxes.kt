@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun <T> comboBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.comboBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.comboBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()
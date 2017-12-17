@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun <T> choiceBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.choiceBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.choiceBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@KotfxDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()
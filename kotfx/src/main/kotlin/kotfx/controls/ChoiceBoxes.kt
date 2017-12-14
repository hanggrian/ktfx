@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import kotfx.ChildManager
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun <T> choiceBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.choiceBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()
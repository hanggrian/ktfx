@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import javafx.scene.control.SingleSelectionModel
import kotfx._Pane
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl

class _ChoiceBox<T>(items: ObservableList<T>) : ChoiceBox<T>(items), _Control<ChoiceBox<T>> {
    override val node: ChoiceBox<T> get() = this

    fun selectionModel(value: SingleSelectionModel<T>) = setSelectionModel(value)
    fun items(value: ObservableList<T>) = setItems(value)
    fun value(value: T) = setValue(value)
}

@JvmOverloads
inline fun <T> choiceBoxOf(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl _ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = _ChoiceBox(items).apply { if (init != null) init() }

@JvmOverloads
inline fun <T> _Pane.choiceBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl _ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = choiceBoxOf(items, init).add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.control.ChoiceBox
import javafx.scene.control.SingleSelectionModel
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _ChoiceBox<T>(items: ObservableList<T>) : ChoiceBox<T>(items), _Control<ChoiceBox<T>> {
    override val control: ChoiceBox<T> get() = this

    fun selectionModel(model: SingleSelectionModel<T>) = setSelectionModel(model)
    fun items(items: ObservableList<T>) = setItems(items)
    fun value(value: T) = setValue(value)
}

@JvmOverloads
inline fun <T> choiceBox(
        items: ObservableList<T>,
        noinline init: ((@ControlDsl _ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = _ChoiceBox(items).apply { if (init != null) init() }

@JvmOverloads
inline fun <T> ChildManager.choiceBox(
        items: ObservableList<T>,
        noinline init: ((@ControlDsl _ChoiceBox<T>).() -> Unit)? = null
): ChoiceBox<T> = _ChoiceBox(items).apply { if (init != null) init() }.add()
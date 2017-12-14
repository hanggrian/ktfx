@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafx.scene.control.SingleSelectionModel
import kotfx._Pane
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl

class _ComboBox<T>(items: ObservableList<T>) : ComboBox<T>(items), _ComboBoxBase<ComboBox<T>, T> {
    override val node: ComboBox<T> get() = this

    fun selectionModel(value: SingleSelectionModel<T>) = setSelectionModel(value)
    fun items(value: ObservableList<T>) = setItems(value)
    fun visibleRowCount(value: Int) = setVisibleRowCount(value)
    fun placeholder(value: Node) = setPlaceholder(value)
}

@JvmOverloads
inline fun <T> comboBoxOf(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl _ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = _ComboBox(items).apply { if (init != null) init() }

@JvmOverloads
inline fun <T> _Pane.comboBox(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl _ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = comboBoxOf(items, init).add()
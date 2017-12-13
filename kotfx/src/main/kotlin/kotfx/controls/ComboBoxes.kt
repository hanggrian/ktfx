@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafx.scene.control.SingleSelectionModel
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _ComboBox<T>(items: ObservableList<T>) : ComboBox<T>(items), _ComboBoxBase<ComboBox<T>, T> {
    override val control: ComboBox<T> get() = this

    fun selectionModel(model: SingleSelectionModel<T>) = setSelectionModel(model)
    fun items(items: ObservableList<T>) = setItems(items)
    fun visibleRowCount(count: Int) = setVisibleRowCount(count)
    fun placeholder(placeholder: Node) = setPlaceholder(placeholder)
}

@JvmOverloads
inline fun <T> comboBox(
        items: ObservableList<T>,
        noinline init: ((@ControlDsl _ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = _ComboBox(items).apply { if (init != null) init() }

@JvmOverloads
inline fun <T> ChildManager.comboBox(
        items: ObservableList<T>,
        noinline init: ((@ControlDsl _ComboBox<T>).() -> Unit)? = null
): ComboBox<T> = _ComboBox(items).apply { if (init != null) init() }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.scene.Node
import javafx.scene.control.FocusModel
import javafx.scene.control.ListView
import javafx.scene.control.MultipleSelectionModel
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _ListView<T>(items: ObservableList<T>) : ListView<T>(items), _Control<ListView<T>> {
    override val control: ListView<T> get() = this

    fun selectionModel(model: MultipleSelectionModel<T>) = setSelectionModel(model)
    fun items(items: ObservableList<T>) = setItems(items)
    fun placeholder(placeholder: Node) = setPlaceholder(placeholder)
    fun focusModel(model: FocusModel<T>) = setFocusModel(model)
    fun orientation(orientation: Orientation) = setOrientation(orientation)
    fun cellFixedSize(size: Number) = setFixedCellSize(size.toDouble())
    fun editable(editable: Boolean) = setEditable(editable)
}

@JvmOverloads
inline fun <T> listView(
        items: ObservableList<T>,
        noinline init: ((@ControlDsl _ListView<T>).() -> Unit)? = null
): ListView<T> = _ListView(items).apply { if (init != null) init() }

@JvmOverloads
inline fun <T> ChildManager.listView(
        items: ObservableList<T>,
        noinline init: ((@ControlDsl _ListView<T>).() -> Unit)? = null
): ListView<T> = _ListView(items).apply { if (init != null) init() }.add()
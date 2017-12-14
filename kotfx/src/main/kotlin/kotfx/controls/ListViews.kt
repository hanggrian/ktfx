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
import kotfx._Pane
import kotfx.collections.mutableObservableListOf
import kotfx.internal.ControlDsl

class _ListView<T>(items: ObservableList<T>) : ListView<T>(items), _Control<ListView<T>> {
    override val node: ListView<T> get() = this

    fun selectionModel(value: MultipleSelectionModel<T>) = setSelectionModel(value)
    fun items(value: ObservableList<T>) = setItems(value)
    fun placeholder(value: Node) = setPlaceholder(value)
    fun focusModel(value: FocusModel<T>) = setFocusModel(value)
    fun orientation(value: Orientation) = setOrientation(value)
    fun cellFixedSize(value: Number) = setFixedCellSize(value.toDouble())
    fun editable(value: Boolean) = setEditable(value)
}

@JvmOverloads
inline fun <T> listViewOf(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl _ListView<T>).() -> Unit)? = null
): ListView<T> = _ListView(items).apply { if (init != null) init() }

@JvmOverloads
inline fun <T> _Pane.listView(
        items: ObservableList<T> = mutableObservableListOf(),
        noinline init: ((@ControlDsl _ListView<T>).() -> Unit)? = null
): ListView<T> = listViewOf(items, init).add()
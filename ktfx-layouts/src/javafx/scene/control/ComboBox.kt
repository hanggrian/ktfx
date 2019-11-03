@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox

/** Create a [ComboBox] with initialization block. */
inline fun <T> comboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> = ComboBox(items).apply(init)

/** Add a [ComboBox] to this manager. */
fun <T> NodeManager.comboBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): ComboBox<T> = addNode(ComboBox(items))

/** Add a [ComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.comboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> = addNode(ComboBox(items), init)

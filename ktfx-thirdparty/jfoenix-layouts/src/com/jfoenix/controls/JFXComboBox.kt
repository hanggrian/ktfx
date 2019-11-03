@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXComboBox
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXComboBox] with initialization block. */
inline fun <T> jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> = JFXComboBox(items).apply(init)

/** Add a [JFXComboBox] to this manager. */
fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList()
): JFXComboBox<T> = addNode(JFXComboBox(items))

/** Add a [JFXComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> = addNode(JFXComboBox(items), init)

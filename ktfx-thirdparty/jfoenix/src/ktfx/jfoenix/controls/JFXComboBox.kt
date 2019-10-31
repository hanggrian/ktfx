@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXComboBox
import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXComboBox] with initialization block. */
inline fun <T> jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> = JFXComboBox(items).apply(init)

/** Add a [JFXComboBox] to this manager. */
fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf()
): JFXComboBox<T> = addNode(JFXComboBox(items))

/** Add a [JFXComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> = addNode(JFXComboBox(items), init)

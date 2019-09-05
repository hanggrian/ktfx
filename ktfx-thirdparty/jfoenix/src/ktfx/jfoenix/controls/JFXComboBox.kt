@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXComboBox
import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXComboBox] to this manager. */
fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf()
): JFXComboBox<T> = JFXComboBox(items).add()

/** Add a [JFXComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.jfxComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker JFXComboBox<T>).() -> Unit
): JFXComboBox<T> = jfxComboBox(items).apply(init)

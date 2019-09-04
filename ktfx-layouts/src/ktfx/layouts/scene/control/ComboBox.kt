@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import ktfx.collections.observableListOf

/** Add a [ComboBox] to this manager. */
fun <T> NodeManager.comboBox(
    items: ObservableList<T> = observableListOf()
): ComboBox<T> = ComboBox(items).add()

/** Add a [ComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.comboBox(
    items: ObservableList<T> = observableListOf(),
    init: (@LayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> = comboBox(items).apply(init)

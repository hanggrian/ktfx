@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import ktfx.collections.observableListOf

/** Create a [ComboBox] with initialization block. */
inline fun <T> comboBox(
    items: ObservableList<T> = observableListOf(),
    init: (@LayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> = ComboBox(items).apply(init)

/** Add a [ComboBox] to this manager. */
fun <T> NodeManager.comboBox(
    items: ObservableList<T> = observableListOf()
): ComboBox<T> = addNode(ktfx.layouts.comboBox(items) { })

/** Add a [ComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.comboBox(
    items: ObservableList<T> = observableListOf(),
    init: (@LayoutDslMarker ComboBox<T>).() -> Unit
): ComboBox<T> = addNode(ktfx.layouts.comboBox(items, init))

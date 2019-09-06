@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckComboBox

/** Create a [CheckComboBox] with initialization block. */
inline fun <T> checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> = CheckComboBox(items).apply(init)

/** Add a [CheckComboBox] to this manager. */
fun <T> NodeManager.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf()
): CheckComboBox<T> = addNode(ktfx.controlsfx.checkComboBox(items) { })

/** Add a [CheckComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> = addNode(ktfx.controlsfx.checkComboBox(items, init))

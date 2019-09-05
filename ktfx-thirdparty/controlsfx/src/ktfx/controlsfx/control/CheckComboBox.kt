@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.collections.ObservableList
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckComboBox

/** Add a [CheckComboBox] to this manager. */
fun <T> NodeManager.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf()
): CheckComboBox<T> = CheckComboBox(items).add()

/** Add a [CheckComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: (@LayoutDslMarker CheckComboBox<T>).() -> Unit
): CheckComboBox<T> = checkComboBox(items).apply(init)

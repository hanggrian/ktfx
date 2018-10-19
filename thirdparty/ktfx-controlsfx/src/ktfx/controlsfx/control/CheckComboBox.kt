@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.CheckComboBox

/** Creates a [CheckComboBox]. */
fun <T> checkComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = CheckComboBox(items).also { init?.invoke(it) }

/** Creates a [CheckComboBox] and add it to this manager. */
inline fun <T> NodeManager.checkComboBox(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = ktfx.controlsfx.checkComboBox(items, init)()
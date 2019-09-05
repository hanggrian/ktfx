@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionComboBox

/** Add a [PrefixSelectionComboBox] to this manager. */
fun <T> NodeManager.prefixSelectionComboBox(): PrefixSelectionComboBox<T> =
    PrefixSelectionComboBox<T>().add()

/** Add a [PrefixSelectionComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionComboBox(
    init: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> = prefixSelectionComboBox<T>().apply(init)

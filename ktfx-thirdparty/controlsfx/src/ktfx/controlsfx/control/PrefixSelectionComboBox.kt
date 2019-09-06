@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionComboBox

/** Create a [PrefixSelectionComboBox] with initialization block. */
inline fun <T> prefixSelectionComboBox(
    init: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> = PrefixSelectionComboBox<T>().apply(init)

/** Add a [PrefixSelectionComboBox] to this manager. */
fun <T> NodeManager.prefixSelectionComboBox(): PrefixSelectionComboBox<T> =
    addNode(ktfx.controlsfx.prefixSelectionComboBox { })

/** Add a [PrefixSelectionComboBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionComboBox(
    init: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> = addNode(ktfx.controlsfx.prefixSelectionComboBox(init))

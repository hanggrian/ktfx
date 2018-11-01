@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeManager
import ktfx.LayoutDsl
import org.controlsfx.control.PrefixSelectionComboBox

/** Creates a [PrefixSelectionComboBox]. */
fun <T> prefixSelectionComboBox(
    init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = PrefixSelectionComboBox<T>().also { init?.invoke(it) }

/** Creates a [PrefixSelectionComboBox] and add it to this manager. */
inline fun <T> NodeManager.prefixSelectionComboBox(
    noinline init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = ktfx.controlsfx.prefixSelectionComboBox(init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.PrefixSelectionComboBox

/** Creates a [PrefixSelectionComboBox]. */
fun <T> prefixSelectionComboBox(
    init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = PrefixSelectionComboBox<T>().also {
    init?.invoke(it)
}

/** Creates a [PrefixSelectionComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.prefixSelectionComboBox(
    noinline init: ((@LayoutDsl PrefixSelectionComboBox<T>).() -> Unit)? = null
): PrefixSelectionComboBox<T> = ktfx.controlsfx.prefixSelectionComboBox(init)()
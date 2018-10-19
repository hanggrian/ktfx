@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Creates a [PrefixSelectionChoiceBox]. */
fun <T> prefixSelectionChoiceBox(
    init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = PrefixSelectionChoiceBox<T>().also { init?.invoke(it) }

/** Creates a [PrefixSelectionChoiceBox] and add it to this manager. */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    noinline init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = ktfx.controlsfx.prefixSelectionChoiceBox(init)()
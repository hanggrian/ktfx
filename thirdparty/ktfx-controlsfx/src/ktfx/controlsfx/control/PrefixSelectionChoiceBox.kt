@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Creates a [PrefixSelectionChoiceBox]. */
fun <T> prefixSelectionChoiceBox(
    init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = PrefixSelectionChoiceBox<T>().also { init?.invoke(it) }

/** Creates a [PrefixSelectionChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.prefixSelectionChoiceBox(
    noinline init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = ktfx.controlsfx.prefixSelectionChoiceBox(init)()
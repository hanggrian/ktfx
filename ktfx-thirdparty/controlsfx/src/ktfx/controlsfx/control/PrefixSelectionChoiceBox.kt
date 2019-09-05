@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Add a [PrefixSelectionChoiceBox] to this manager. */
fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> =
    PrefixSelectionChoiceBox<T>().add()

/** Add a [PrefixSelectionChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    init: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> = prefixSelectionChoiceBox<T>().apply(init)

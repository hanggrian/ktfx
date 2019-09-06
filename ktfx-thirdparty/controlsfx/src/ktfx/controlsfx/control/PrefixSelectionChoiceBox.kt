@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Create a [PrefixSelectionChoiceBox] with initialization block. */
inline fun <T> prefixSelectionChoiceBox(
    init: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> = PrefixSelectionChoiceBox<T>().apply(init)

/** Add a [PrefixSelectionChoiceBox] to this manager. */
fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> =
    addNode(ktfx.controlsfx.prefixSelectionChoiceBox { })

/** Add a [PrefixSelectionChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    init: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> = addNode(ktfx.controlsfx.prefixSelectionChoiceBox(init))

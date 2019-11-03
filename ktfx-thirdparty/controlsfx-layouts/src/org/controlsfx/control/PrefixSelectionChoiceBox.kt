@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Create a [PrefixSelectionChoiceBox] with initialization block. */
inline fun <T> prefixSelectionChoiceBox(
    init: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> = PrefixSelectionChoiceBox<T>().apply(init)

/** Add a [PrefixSelectionChoiceBox] to this manager. */
fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> =
    addNode(PrefixSelectionChoiceBox())

/** Add a [PrefixSelectionChoiceBox] with initialization block to this manager. */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    init: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> = addNode(PrefixSelectionChoiceBox(), init)

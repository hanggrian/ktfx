@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.MaskerPane

/** Create a [MaskerPane] with initialization block. */
inline fun maskerPane(
    init: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane = MaskerPane().apply(init)

/** Add a [MaskerPane] to this manager. */
fun NodeManager.maskerPane(): MaskerPane =
    addNode(ktfx.controlsfx.maskerPane { })

/** Add a [MaskerPane] with initialization block to this manager. */
inline fun NodeManager.maskerPane(
    init: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane = addNode(ktfx.controlsfx.maskerPane(init))

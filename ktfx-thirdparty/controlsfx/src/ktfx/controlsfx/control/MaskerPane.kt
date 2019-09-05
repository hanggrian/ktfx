@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.MaskerPane

/** Add a [MaskerPane] to this manager. */
fun NodeManager.maskerPane(): MaskerPane =
    MaskerPane().add()

/** Add a [MaskerPane] with initialization block to this manager. */
inline fun NodeManager.maskerPane(
    init: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane = maskerPane().apply(init)

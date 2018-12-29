@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import org.controlsfx.control.MaskerPane

/** Creates a [MaskerPane]. */
fun maskerPane(
    init: ((@LayoutMarker MaskerPane).() -> Unit)? = null
): MaskerPane = MaskerPane().also { init?.invoke(it) }

/** Creates a [MaskerPane] and add it to this manager. */
inline fun NodeInvokable.maskerPane(
    noinline init: ((@LayoutMarker MaskerPane).() -> Unit)? = null
): MaskerPane = ktfx.controlsfx.maskerPane(init)()
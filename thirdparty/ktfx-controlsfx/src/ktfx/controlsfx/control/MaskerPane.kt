@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeInvokable
import ktfx.LayoutDsl
import org.controlsfx.control.MaskerPane

/** Creates a [MaskerPane]. */
fun maskerPane(
    init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = MaskerPane().also { init?.invoke(it) }

/** Creates a [MaskerPane] and add it to this manager. */
inline fun NodeInvokable.maskerPane(
    noinline init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = ktfx.controlsfx.maskerPane(init)()
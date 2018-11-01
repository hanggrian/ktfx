@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeManager
import ktfx.LayoutDsl
import org.controlsfx.control.StatusBar

/** Creates a [StatusBar]. */
fun statusBar(
    init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also { init?.invoke(it) }

/** Creates a [StatusBar] and add it to this manager. */
inline fun NodeManager.statusBar(
    noinline init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = ktfx.controlsfx.statusBar(init)()
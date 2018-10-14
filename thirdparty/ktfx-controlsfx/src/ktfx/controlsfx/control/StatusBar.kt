@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.StatusBar

/** Creates a [StatusBar]. */
fun statusBar(
    init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also { init?.invoke(it) }

/** Creates a [StatusBar] and add it to this manager. */
inline fun NodeManager.statusBar(
    noinline init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = ktfx.controlsfx.statusBar(init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.StatusBar

/** Creates a [StatusBar]. */
fun statusBar(
    init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also { init?.invoke(it) }

/** Creates a [StatusBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.statusBar(
    noinline init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = ktfx.controlsfx.statusBar(init)()
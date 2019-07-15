@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.StatusBar

/** Creates a [StatusBar]. */
fun statusBar(
    init: ((@LayoutDslMarker StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also { init?.invoke(it) }

/** Creates a [StatusBar] and add it to this manager. */
inline fun NodeManager.statusBar(
    noinline init: ((@LayoutDslMarker StatusBar).() -> Unit)? = null
): StatusBar = ktfx.controlsfx.statusBar(init).add()

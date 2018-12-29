@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import org.controlsfx.control.StatusBar

/** Creates a [StatusBar]. */
fun statusBar(
    init: ((@LayoutMarker StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also { init?.invoke(it) }

/** Creates a [StatusBar] and add it to this manager. */
inline fun NodeInvokable.statusBar(
    noinline init: ((@LayoutMarker StatusBar).() -> Unit)? = null
): StatusBar = ktfx.controlsfx.statusBar(init)()
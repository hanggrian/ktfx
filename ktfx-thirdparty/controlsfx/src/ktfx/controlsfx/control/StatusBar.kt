@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.StatusBar

/** Add a [StatusBar] to this manager. */
fun NodeManager.statusBar(): StatusBar =
    StatusBar().add()

/** Add a [StatusBar] with initialization block to this manager. */
inline fun NodeManager.statusBar(
    init: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar = statusBar().apply(init)

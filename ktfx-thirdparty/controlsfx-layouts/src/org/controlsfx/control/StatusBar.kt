@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.StatusBar

/** Create a [StatusBar] with initialization block. */
inline fun statusBar(
    init: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar = StatusBar().apply(init)

/** Add a [StatusBar] to this manager. */
fun NodeManager.statusBar(): StatusBar =
    addNode(StatusBar())

/** Add a [StatusBar] with initialization block to this manager. */
inline fun NodeManager.statusBar(
    init: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar = addNode(StatusBar(), init)

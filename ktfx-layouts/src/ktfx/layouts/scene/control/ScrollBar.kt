@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.ScrollBar

/** Add a [ScrollBar] to this manager. */
fun NodeManager.scrollBar(): ScrollBar =
    ScrollBar().add()

/** Add a [ScrollBar] with initialization block to this manager. */
inline fun NodeManager.scrollBar(
    init: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar = scrollBar().apply(init)

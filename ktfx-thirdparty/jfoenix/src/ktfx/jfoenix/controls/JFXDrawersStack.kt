@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXDrawersStack] to this manager. */
fun NodeManager.jfxDrawersStack(): JFXDrawersStack =
    JFXDrawersStack().add()

/** Add a [JFXDrawersStack] with initialization block to this manager. */
inline fun NodeManager.jfxDrawersStack(
    init: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack = jfxDrawersStack().apply(init)

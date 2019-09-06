@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawersStack
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXDrawersStack] with initialization block. */
inline fun jfxDrawersStack(
    init: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack = JFXDrawersStack().apply(init)

/** Add a [JFXDrawersStack] to this manager. */
fun NodeManager.jfxDrawersStack(): JFXDrawersStack =
    addNode(ktfx.jfoenix.jfxDrawersStack { })

/** Add a [JFXDrawersStack] with initialization block to this manager. */
inline fun NodeManager.jfxDrawersStack(
    init: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack = addNode(ktfx.jfoenix.jfxDrawersStack(init))

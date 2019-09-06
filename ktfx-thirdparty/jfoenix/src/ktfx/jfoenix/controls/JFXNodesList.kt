@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXNodesList] with initialization block. */
inline fun jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList = JFXNodesList().apply(init)

/** Add a [JFXNodesList] to this manager. */
fun NodeManager.jfxNodesList(): JFXNodesList =
    addNode(ktfx.jfoenix.jfxNodesList { })

/** Add a [JFXNodesList] with initialization block to this manager. */
inline fun NodeManager.jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList = addNode(ktfx.jfoenix.jfxNodesList(init))

@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXNodesList] to this manager. */
fun NodeManager.jfxNodesList(): JFXNodesList =
    JFXNodesList().add()

/** Add a [JFXNodesList] with initialization to this manager. */
inline fun NodeManager.jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList = jfxNodesList().apply(init)

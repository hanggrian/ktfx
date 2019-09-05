@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXCheckBox] to this manager. */
fun NodeManager.jfxCheckBox(
    text: String? = null
): JFXCheckBox = JFXCheckBox(text).add()

/** Add a [JFXCheckBox] with initialization block to this manager. */
inline fun NodeManager.jfxCheckBox(
    text: String? = null,
    init: (@LayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox = jfxCheckBox(text).apply(init)

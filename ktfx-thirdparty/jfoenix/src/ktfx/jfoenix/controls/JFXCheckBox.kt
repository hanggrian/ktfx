@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXCheckBox] with initialization block. */
inline fun jfxCheckBox(
    text: String? = null,
    init: (@LayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox = JFXCheckBox(text).apply(init)

/** Add a [JFXCheckBox] to this manager. */
fun NodeManager.jfxCheckBox(
    text: String? = null
): JFXCheckBox = addNode(ktfx.jfoenix.jfxCheckBox(text) { })

/** Add a [JFXCheckBox] with initialization block to this manager. */
inline fun NodeManager.jfxCheckBox(
    text: String? = null,
    init: (@LayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox = addNode(ktfx.jfoenix.jfxCheckBox(text, init))
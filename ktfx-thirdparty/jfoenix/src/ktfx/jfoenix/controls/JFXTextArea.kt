@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTextArea] to this manager. */
fun NodeManager.jfxTextArea(
    text: String? = null
): JFXTextArea = JFXTextArea(text).add()

/** Add a [JFXTextArea] with initialization block to this manager. */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea = jfxTextArea(text).apply(init)

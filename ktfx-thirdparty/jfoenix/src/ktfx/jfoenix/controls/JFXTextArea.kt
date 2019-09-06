@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTextArea] with initialization block. */
inline fun jfxTextArea(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea = JFXTextArea(text).apply(init)

/** Add a [JFXTextArea] to this manager. */
fun NodeManager.jfxTextArea(
    text: String? = null
): JFXTextArea = addNode(ktfx.jfoenix.jfxTextArea(text) { })

/** Add a [JFXTextArea] with initialization block to this manager. */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea = addNode(ktfx.jfoenix.jfxTextArea(text, init))

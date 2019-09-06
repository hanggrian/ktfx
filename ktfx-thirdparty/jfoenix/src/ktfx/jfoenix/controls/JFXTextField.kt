@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextField
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTextField] with initialization block. */
inline fun jfxTextField(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField = JFXTextField(text).apply(init)

/** Add a [JFXTextField] to this manager. */
fun NodeManager.jfxTextField(
    text: String? = null
): JFXTextField = addNode(ktfx.jfoenix.jfxTextField(text) { })

/** Add a [JFXTextField] with initialization block to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField = addNode(ktfx.jfoenix.jfxTextField(text, init))

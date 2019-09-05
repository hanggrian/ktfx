@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextField
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTextField] to this manager. */
fun NodeManager.jfxTextField(
    text: String? = null
): JFXTextField = JFXTextField(text).add()

/** Add a [JFXTextField] with initialization block to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField = jfxTextField(text).apply(init)

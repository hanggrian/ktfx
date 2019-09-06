@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXRadioButton] with initialization block. */
inline fun jfxRadioButton(
    text: String? = null,
    init: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton = JFXRadioButton(text).apply(init)

/** Add a [JFXRadioButton] to this manager. */
fun NodeManager.jfxRadioButton(
    text: String? = null
): JFXRadioButton = addNode(ktfx.jfoenix.jfxRadioButton(text) { })

/** Add a [JFXRadioButton] with initialization block to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    init: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton = addNode(ktfx.jfoenix.jfxRadioButton(text, init))

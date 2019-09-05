@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXRadioButton] to this manager. */
fun NodeManager.jfxRadioButton(
    text: String? = null
): JFXRadioButton = JFXRadioButton(text).add()

/** Add a [JFXRadioButton] with initialization to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    init: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton = jfxRadioButton(text).apply(init)

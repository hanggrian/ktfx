@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXRadioButton]. */
fun jfxRadioButton(
    text: String? = null,
    init: ((@LayoutDslMarker JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = JFXRadioButton(text).also { init?.invoke(it) }

/** Creates a [JFXRadioButton] and add it to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    noinline init: ((@LayoutDslMarker JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = ktfx.jfoenix.jfxRadioButton(text, init).add()

@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRadioButton
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXRadioButton]. */
fun jfxRadioButton(
    text: String? = null,
    init: ((@LayoutDsl JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = JFXRadioButton(text).also { init?.invoke(it) }

/** Creates a [JFXRadioButton] and add it to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = ktfx.jfoenix.jfxRadioButton(text, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXRadioButton]. */
fun jfxRadioButton(
    text: String? = null,
    init: ((@LayoutMarker JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = JFXRadioButton(text).also { init?.invoke(it) }

/** Creates a [JFXRadioButton] and add it to this manager. */
inline fun NodeInvokable.jfxRadioButton(
    text: String? = null,
    noinline init: ((@LayoutMarker JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = ktfx.jfoenix.jfxRadioButton(text, init)()
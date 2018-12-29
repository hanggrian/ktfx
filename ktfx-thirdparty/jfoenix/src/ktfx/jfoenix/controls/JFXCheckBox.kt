@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXCheckBox]. */
fun jfxCheckBox(
    text: String? = null,
    init: ((@LayoutMarker JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = JFXCheckBox(text).also { init?.invoke(it) }

/** Creates a [JFXCheckBox] and add it to this manager. */
inline fun NodeInvokable.jfxCheckBox(
    text: String? = null,
    noinline init: ((@LayoutMarker JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = ktfx.jfoenix.jfxCheckBox(text, init)()
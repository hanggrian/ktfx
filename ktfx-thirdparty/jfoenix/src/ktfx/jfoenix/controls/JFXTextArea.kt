@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXTextArea]. */
fun jfxTextArea(
    text: String? = null,
    init: ((@LayoutDslMarker JFXTextArea).() -> Unit)? = null
): JFXTextArea = JFXTextArea(text.orEmpty()).also { init?.invoke(it) }

/** Creates a [JFXTextArea] and add it to this manager. */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    noinline init: ((@LayoutDslMarker JFXTextArea).() -> Unit)? = null
): JFXTextArea = ktfx.jfoenix.jfxTextArea(text, init).add()

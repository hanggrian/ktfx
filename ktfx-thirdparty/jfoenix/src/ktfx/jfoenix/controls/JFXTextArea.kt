@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutDsl

/** Creates a [JFXTextArea]. */
fun jfxTextArea(
    text: String? = null,
    init: ((@LayoutDsl JFXTextArea).() -> Unit)? = null
): JFXTextArea = JFXTextArea(text.orEmpty()).also { init?.invoke(it) }

/** Creates a [JFXTextArea] and add it to this manager. */
inline fun NodeInvokable.jfxTextArea(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXTextArea).() -> Unit)? = null
): JFXTextArea = ktfx.jfoenix.jfxTextArea(text, init)()
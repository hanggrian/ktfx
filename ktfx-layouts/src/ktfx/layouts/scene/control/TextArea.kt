@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TextArea
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [TextArea]. */
fun textArea(
    text: String = "",
    init: ((@LayoutDsl TextArea).() -> Unit)? = null
): TextArea = TextArea(text).also { init?.invoke(it) }

/** Creates a [TextArea] and add it to this manager. */
inline fun NodeManager.textArea(
    text: String = "",
    noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null
): TextArea = ktfx.layouts.textArea(text, init)()
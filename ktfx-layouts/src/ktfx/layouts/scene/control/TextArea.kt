@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TextArea

/** Creates a [TextArea]. */
fun textArea(
    text: String = "",
    init: ((@LayoutMarker TextArea).() -> Unit)? = null
): TextArea = TextArea(text).also { init?.invoke(it) }

/** Creates a [TextArea] and add it to this manager. */
inline fun NodeInvokable.textArea(
    text: String = "",
    noinline init: ((@LayoutMarker TextArea).() -> Unit)? = null
): TextArea = ktfx.layouts.textArea(text, init)()
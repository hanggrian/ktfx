@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TextArea

/** Add a [TextArea] to this manager. */
fun NodeManager.textArea(
    text: String = ""
): TextArea = TextArea(text).add()

/** Add a [TextArea] with initialization block to this manager. */
inline fun NodeManager.textArea(
    text: String = "",
    init: (@LayoutDslMarker TextArea).() -> Unit
): TextArea = textArea(text).apply(init)

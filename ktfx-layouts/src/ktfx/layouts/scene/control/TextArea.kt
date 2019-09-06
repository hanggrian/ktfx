@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TextArea

/** Create a [TextArea] with initialization block. */
inline fun textArea(
    text: String = "",
    init: (@LayoutDslMarker TextArea).() -> Unit
): TextArea = TextArea(text).apply(init)

/** Add a [TextArea] to this manager. */
fun NodeManager.textArea(
    text: String = ""
): TextArea = addNode(ktfx.layouts.textArea(text) { })

/** Add a [TextArea] with initialization block to this manager. */
inline fun NodeManager.textArea(
    text: String = "",
    init: (@LayoutDslMarker TextArea).() -> Unit
): TextArea = addNode(ktfx.layouts.textArea(text, init))

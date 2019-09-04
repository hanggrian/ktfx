@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.text.Text

/** Add a [Text] to this manager. */
fun NodeManager.text(
    text: String? = null
): Text = Text(text).add()

/** Add a [Text] with initialization block to this manager. */
inline fun NodeManager.text(
    text: String? = null,
    init: (@LayoutDslMarker Text).() -> Unit
): Text = text(text).apply(init)

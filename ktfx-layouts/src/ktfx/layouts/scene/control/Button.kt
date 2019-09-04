@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

/** Add a [Button] to this manager. */
fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null
): Button = Button(text, graphic).add()

/** Add a [Button] with initialization block to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Button).() -> Unit
): Button = button(text, graphic).also(init).add()
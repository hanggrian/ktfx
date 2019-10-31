@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

/** Create a [Button] with initialization block. */
inline fun button(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Button).() -> Unit
): Button = Button(text, graphic).apply(init)

/** Add a [Button] to this manager. */
fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null
): Button = addNode(Button(text, graphic))

/** Add a [Button] with initialization block to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Button).() -> Unit
): Button = addNode(Button(text, graphic), init)

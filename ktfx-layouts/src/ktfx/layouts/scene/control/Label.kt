@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label

/** Add a [Label] to this manager. */
fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null
): Label = Label(text, graphic).add()

/** Add a [Label] with initialization block to this manager. */
inline fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Label).() -> Unit
): Label = label(text, graphic).apply(init)

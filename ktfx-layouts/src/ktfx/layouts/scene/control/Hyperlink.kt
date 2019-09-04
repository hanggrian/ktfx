@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink

/** Add a [Hyperlink] to this manager. */
fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null
): Hyperlink = Hyperlink(text, graphic).add()

/** Add a [Hyperlink] with initialization block to this manager. */
inline fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink = hyperlink(text, graphic).apply(init)

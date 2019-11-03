@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink

/** Create a [Hyperlink] with initialization block. */
inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink = Hyperlink(text, graphic).apply(init)

/** Add a [Hyperlink] to this manager. */
fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null
): Hyperlink = addNode(Hyperlink(text, graphic))

/** Add a [Hyperlink] with initialization block to this manager. */
inline fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Hyperlink).() -> Unit
): Hyperlink = addNode(Hyperlink(text, graphic), init)

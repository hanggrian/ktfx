@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label

/** Create a [Label] with initialization block. */
inline fun label(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Label).() -> Unit
): Label = Label(text, graphic).apply(init)

/** Add a [Label] to this manager. */
fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null
): Label = addNode(Label(text, graphic))

/** Add a [Label] with initialization block to this manager. */
inline fun NodeManager.label(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker Label).() -> Unit
): Label = addNode(Label(text, graphic), init)

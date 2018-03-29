@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label

inline fun label(
    text: String? = null,
    graphic: Node? = null
): Label = label(text, graphic) { }

inline fun label(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl Label).() -> Unit
): Label = Label(text, graphic).apply(init)

inline fun LayoutManager<Node>.label(
    text: String? = null,
    graphic: Node? = null
): Label = label(text, graphic) { }

inline fun LayoutManager<Node>.label(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl Label).() -> Unit
): Label = ktfx.layouts.label(text, graphic, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink

inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null
): Hyperlink = hyperlink(text, graphic) { }

inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl Hyperlink).() -> Unit
): Hyperlink = Hyperlink(text, graphic).apply(init)

inline fun LayoutManager<Node>.hyperlink(
    text: String? = null,
    graphic: Node? = null
): Hyperlink = hyperlink(text, graphic) { }

inline fun LayoutManager<Node>.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl Hyperlink).() -> Unit
): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init).add()
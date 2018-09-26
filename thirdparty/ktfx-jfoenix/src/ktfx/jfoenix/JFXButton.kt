@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXButton]. */
fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl JFXButton).() -> Unit)? = null
): JFXButton = JFXButton(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [JFXButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl JFXButton).() -> Unit)? = null
): JFXButton = ktfx.jfoenix.jfxButton(text, graphic, init)()

/** Create a styled [JFXButton]. */
fun styledJFXButton(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl JFXButton).() -> Unit)? = null
): JFXButton = JFXButton(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [JFXButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledJFXButton(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl JFXButton).() -> Unit)? = null
): JFXButton = ktfx.jfoenix.styledJFXButton(styleClass, text, graphic, init)()
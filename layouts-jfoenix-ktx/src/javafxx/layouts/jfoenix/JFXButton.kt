@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.jfoenix

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager

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
): JFXButton = javafxx.layouts.jfoenix.jfxButton(text, graphic, init)()

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
): JFXButton = javafxx.layouts.jfoenix.styledJFXButton(styleClass, text, graphic, init)()
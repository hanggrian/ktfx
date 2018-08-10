@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.jfoenix

import com.jfoenix.controls.JFXCheckBox
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager

/** Creates a [JFXCheckBox]. */
fun jfxCheckBox(
    text: String? = null,
    init: ((@LayoutDsl JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = JFXCheckBox(text).also {
    init?.invoke(it)
}

/** Creates a [JFXCheckBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxCheckBox(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = javafxx.layouts.jfoenix.jfxCheckBox(text, init)()

/** Create a styled [JFXCheckBox]. */
fun styledJFXCheckBox(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = JFXCheckBox(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [JFXCheckBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledJFXCheckBox(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = javafxx.layouts.jfoenix.styledJFXCheckBox(styleClass, text, init)()
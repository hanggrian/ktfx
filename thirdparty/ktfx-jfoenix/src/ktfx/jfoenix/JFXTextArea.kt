@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTextArea
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXTextArea]. */
fun jfxTextArea(
    text: String? = null,
    init: ((@LayoutDsl JFXTextArea).() -> Unit)? = null
): JFXTextArea = JFXTextArea(text).also {
    init?.invoke(it)
}

/** Creates a [JFXTextArea] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxTextArea(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXTextArea).() -> Unit)? = null
): JFXTextArea = ktfx.jfoenix.jfxTextArea(text, init)()
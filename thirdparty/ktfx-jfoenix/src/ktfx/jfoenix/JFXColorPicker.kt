@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXColorPicker
import javafx.scene.Node
import javafx.scene.paint.Color
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXColorPicker]. */
fun jfxColorPicker(
    color: Color? = null,
    init: ((@LayoutDsl JFXColorPicker).() -> Unit)? = null
): JFXColorPicker = JFXColorPicker(color).also {
    init?.invoke(it)
}

/** Creates a [JFXColorPicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxClippedPane(
    color: Color? = null,
    noinline init: ((@LayoutDsl JFXColorPicker).() -> Unit)? = null
): JFXColorPicker = ktfx.jfoenix.jfxColorPicker(color, init = init)()
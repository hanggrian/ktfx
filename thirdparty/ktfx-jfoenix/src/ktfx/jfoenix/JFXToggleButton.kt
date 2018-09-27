@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToggleButton
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXToggleButton]. */
fun jfxToggleButton(
    init: ((@LayoutDsl JFXToggleButton).() -> Unit)? = null
): JFXToggleButton = JFXToggleButton().also {
    init?.invoke(it)
}

/** Creates a [JFXToggleButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxToggleButton(
    noinline init: ((@LayoutDsl JFXToggleButton).() -> Unit)? = null
): JFXToggleButton = ktfx.jfoenix.jfxToggleButton(init)()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXPasswordField
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXPasswordField]. */
fun jfxPasswordField(
    init: ((@LayoutDsl JFXPasswordField).() -> Unit)? = null
): JFXPasswordField = JFXPasswordField().also {
    init?.invoke(it)
}

/** Creates a [JFXPasswordField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxPasswordField(
    noinline init: ((@LayoutDsl JFXPasswordField).() -> Unit)? = null
): JFXPasswordField = ktfx.jfoenix.jfxPasswordField(init)()
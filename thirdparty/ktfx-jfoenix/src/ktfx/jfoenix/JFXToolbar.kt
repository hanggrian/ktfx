@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToolbar
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXToolbar]. */
fun jfxToolbar(
    init: ((@LayoutDsl JFXToolbar).() -> Unit)? = null
): JFXToolbar = JFXToolbar().also {
    init?.invoke(it)
}

/** Creates a [JFXToolbar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxToolbar(
    noinline init: ((@LayoutDsl JFXToolbar).() -> Unit)? = null
): JFXToolbar = ktfx.jfoenix.jfxToolbar(init)()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXDrawer]. */
fun jfxDrawer(
    init: ((@LayoutDsl JFXDrawer).() -> Unit)? = null
): JFXDrawer = JFXDrawer().also {
    init?.invoke(it)
}

/** Creates a [JFXDrawer] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxDrawer(
    noinline init: ((@LayoutDsl JFXDrawer).() -> Unit)? = null
): JFXDrawer = ktfx.jfoenix.jfxDrawer(init)()
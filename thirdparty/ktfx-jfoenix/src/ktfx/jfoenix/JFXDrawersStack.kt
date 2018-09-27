@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.JFXDrawersStack
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXDrawersStack]. */
fun jfxDrawersStack(
    init: ((@LayoutDsl JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = JFXDrawersStack().also {
    init?.invoke(it)
}

/** Creates a [JFXDrawer] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxDrawersStack(
    noinline init: ((@LayoutDsl JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = ktfx.jfoenix.jfxDrawersStack(init)()
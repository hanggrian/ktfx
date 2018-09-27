@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXMasonryPane
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXMasonryPane]. */
fun jfxMasonryPane(
    init: ((@LayoutDsl JFXMasonryPane).() -> Unit)? = null
): JFXMasonryPane = JFXMasonryPane().also {
    init?.invoke(it)
}

/** Creates a [JFXMasonryPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxMasonryPane(
    noinline init: ((@LayoutDsl JFXMasonryPane).() -> Unit)? = null
): JFXMasonryPane = ktfx.jfoenix.jfxMasonryPane(init)()
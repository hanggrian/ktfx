@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXHamburger
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXHamburger]. */
fun jfxHamburger(
    init: ((@LayoutDsl JFXHamburger).() -> Unit)? = null
): JFXHamburger = JFXHamburger().also {
    init?.invoke(it)
}

/** Creates a [JFXHamburger] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxHamburger(
    noinline init: ((@LayoutDsl JFXHamburger).() -> Unit)? = null
): JFXHamburger = ktfx.jfoenix.jfxHamburger(init)()
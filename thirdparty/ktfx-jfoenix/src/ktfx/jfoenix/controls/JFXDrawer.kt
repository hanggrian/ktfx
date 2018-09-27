@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

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
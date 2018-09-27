@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXClippedPane]. */
fun jfxClippedPane(
    vararg children: Node,
    init: ((@LayoutDsl JFXClippedPane).() -> Unit)? = null
): JFXClippedPane = JFXClippedPane(*children).also {
    init?.invoke(it)
}

/** Creates a [JFXClippedPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxClippedPane(
    vararg children: Node,
    noinline init: ((@LayoutDsl JFXClippedPane).() -> Unit)? = null
): JFXClippedPane = ktfx.jfoenix.jfxClippedPane(*children, init = init)()
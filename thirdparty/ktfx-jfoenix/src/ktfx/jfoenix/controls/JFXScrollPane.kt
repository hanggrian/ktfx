@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXScrollPane
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXScrollPane]. */
fun jfxScrollPane(
    init: ((@LayoutDsl JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = JFXScrollPane().also {
    init?.invoke(it)
}

/** Creates a [JFXScrollPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxScrollPane(
    noinline init: ((@LayoutDsl JFXScrollPane).() -> Unit)? = null
): JFXScrollPane = ktfx.jfoenix.jfxScrollPane(init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXNodesList
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXNodesList]. */
fun jfxNodesList(
    init: ((@LayoutDsl JFXNodesList).() -> Unit)? = null
): JFXNodesList = JFXNodesList().also {
    init?.invoke(it)
}

/** Creates a [JFXNodesList] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxNodesList(
    noinline init: ((@LayoutDsl JFXNodesList).() -> Unit)? = null
): JFXNodesList = ktfx.jfoenix.jfxNodesList(init)()
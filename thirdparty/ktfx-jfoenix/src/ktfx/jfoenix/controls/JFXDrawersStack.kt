@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXDrawersStack
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXDrawersStack]. */
fun jfxDrawersStack(
    init: ((@LayoutDsl JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = JFXDrawersStack().also { init?.invoke(it) }

/** Creates a [JFXDrawersStack] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxDrawersStack(
    noinline init: ((@LayoutDsl JFXDrawersStack).() -> Unit)? = null
): JFXDrawersStack = ktfx.jfoenix.jfxDrawersStack(init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXProgressBar
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXProgressBar]. */
fun jfxProgressBar(
    progress: Double = 0.0,
    init: ((@LayoutDsl JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = JFXProgressBar(progress).also { init?.invoke(it) }

/** Creates a [JFXProgressBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxProgressBar(
    progress: Double = 0.0,
    noinline init: ((@LayoutDsl JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = ktfx.jfoenix.jfxProgressBar(progress, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXProgressBar
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Creates a [JFXProgressBar]. */
fun jfxProgressBar(
    progress: Double = 0.0,
    init: ((@LayoutDslMarker JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = JFXProgressBar(progress).also { init?.invoke(it) }

/** Creates a [JFXProgressBar] and add it to this manager. */
inline fun NodeManager.jfxProgressBar(
    progress: Double = 0.0,
    noinline init: ((@LayoutDslMarker JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = ktfx.jfoenix.jfxProgressBar(progress, init).add()

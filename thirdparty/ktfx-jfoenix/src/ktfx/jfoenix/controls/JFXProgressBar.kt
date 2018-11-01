@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXProgressBar
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [JFXProgressBar]. */
fun jfxProgressBar(
    progress: Double = 0.0,
    init: ((@LayoutDsl JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = JFXProgressBar(progress).also { init?.invoke(it) }

/** Creates a [JFXProgressBar] and add it to this manager. */
inline fun NodeManager.jfxProgressBar(
    progress: Double = 0.0,
    noinline init: ((@LayoutDsl JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = ktfx.jfoenix.jfxProgressBar(progress, init)()
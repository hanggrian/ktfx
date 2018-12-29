@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXProgressBar
import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker

/** Creates a [JFXProgressBar]. */
fun jfxProgressBar(
    progress: Double = 0.0,
    init: ((@LayoutMarker JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = JFXProgressBar(progress).also { init?.invoke(it) }

/** Creates a [JFXProgressBar] and add it to this manager. */
inline fun NodeInvokable.jfxProgressBar(
    progress: Double = 0.0,
    noinline init: ((@LayoutMarker JFXProgressBar).() -> Unit)? = null
): JFXProgressBar = ktfx.jfoenix.jfxProgressBar(progress, init)()
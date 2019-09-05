@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXProgressBar
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXProgressBar] to this manager. */
fun NodeManager.jfxProgressBar(
    progress: Double = 0.0
): JFXProgressBar = JFXProgressBar(progress).add()

/** Add a [JFXProgressBar] with initialization to this manager. */
inline fun NodeManager.jfxProgressBar(
    progress: Double = 0.0,
    init: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar = jfxProgressBar(progress).apply(init)

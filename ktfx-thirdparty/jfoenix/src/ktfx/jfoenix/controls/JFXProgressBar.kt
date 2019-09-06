@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXProgressBar
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXProgressBar] with initialization block. */
inline fun jfxProgressBar(
    progress: Double = 0.0,
    init: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar = JFXProgressBar(progress).apply(init)

/** Add a [JFXProgressBar] to this manager. */
fun NodeManager.jfxProgressBar(
    progress: Double = 0.0
): JFXProgressBar = addNode(ktfx.jfoenix.jfxProgressBar(progress) { })

/** Add a [JFXProgressBar] with initialization block to this manager. */
inline fun NodeManager.jfxProgressBar(
    progress: Double = 0.0,
    init: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar = addNode(ktfx.jfoenix.jfxProgressBar(progress, init))

@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.ProgressBar

/** Add a [ProgressBar] to this manager. */
fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressBar = ProgressBar(progress).add()

/** Add a [ProgressBar] with initialization block to this manager. */
inline fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar = progressBar(progress).apply(init)

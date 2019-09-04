@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator

/** Add a [ProgressIndicator] to this manager. */
fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressIndicator = ProgressIndicator(progress).add()

/** Add a [ProgressIndicator] with initialization block to this manager. */
inline fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator = progressIndicator(progress).apply(init)

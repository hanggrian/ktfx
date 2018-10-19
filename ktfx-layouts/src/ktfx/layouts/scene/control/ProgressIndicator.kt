@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [ProgressIndicator]. */
fun progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress).also { init?.invoke(it) }

/** Creates a [ProgressIndicator] and add it to this manager. */
inline fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init)()
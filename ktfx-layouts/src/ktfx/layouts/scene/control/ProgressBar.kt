@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ProgressBar

/** Creates a [ProgressBar]. */
fun progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: ((@LayoutDslMarker ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress).also { init?.invoke(it) }

/** Creates a [ProgressBar] and add it to this manager. */
inline fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDslMarker ProgressBar).() -> Unit)? = null
): ProgressBar = ktfx.layouts.progressBar(progress, init).add()

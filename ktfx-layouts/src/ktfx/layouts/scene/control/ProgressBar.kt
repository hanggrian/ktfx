@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ProgressBar

/** Creates a [ProgressBar]. */
fun progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress).also { init?.invoke(it) }

/** Creates a [ProgressBar] and add it to this manager. */
inline fun NodeInvokable.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ktfx.layouts.progressBar(progress, init)()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS

inline fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress).also { init?.invoke(it) }

inline fun LayoutManager<Node>.progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator

inline fun progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress).also { init?.invoke(it) }

inline fun LayoutManager<Node>.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()
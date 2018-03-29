@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS

inline fun progressBar(
    progress: Number = INDETERMINATE_PROGRESS
): ProgressBar = progressBar(progress) { }

fun progressBar(
    progress: Number = INDETERMINATE_PROGRESS,
    init: (@LayoutDsl ProgressBar).() -> Unit
): ProgressBar = ProgressBar(progress.toDouble()).apply(init)

inline fun LayoutManager<Node>.progressBar(
    progress: Number = INDETERMINATE_PROGRESS
): ProgressBar = progressBar(progress) { }

inline fun LayoutManager<Node>.progressBar(
    progress: Number = INDETERMINATE_PROGRESS,
    noinline init: (@LayoutDsl ProgressBar).() -> Unit
): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
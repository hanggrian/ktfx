@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS

inline fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS
): ProgressBar = progressBar(progress) { }

inline fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    init: (@LayoutDsl ProgressBar).() -> Unit
): ProgressBar = ProgressBar(progress).apply(init)

inline fun LayoutManager<Node>.progressBar(
    progress: Double = INDETERMINATE_PROGRESS
): ProgressBar = progressBar(progress) { }

inline fun LayoutManager<Node>.progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    init: (@LayoutDsl ProgressBar).() -> Unit
): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator

inline fun progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS
): ProgressIndicator = progressIndicator(progress) { }

inline fun progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    init: (@LayoutDsl ProgressIndicator).() -> Unit
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply(init)

inline fun LayoutManager<Node>.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS
): ProgressIndicator = progressIndicator(progress) { }

inline fun LayoutManager<Node>.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    init: (@LayoutDsl ProgressIndicator).() -> Unit
): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()
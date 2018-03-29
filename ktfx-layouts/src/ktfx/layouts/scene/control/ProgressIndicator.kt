@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator

fun progressIndicator(
    progress: Number = INDETERMINATE_PROGRESS
): ProgressIndicator = progressIndicator(progress) { }

fun progressIndicator(
    progress: Number = INDETERMINATE_PROGRESS,
    init: (@LayoutDsl ProgressIndicator).() -> Unit
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply(init)

inline fun LayoutManager<Node>.progressIndicator(
    progress: Number = INDETERMINATE_PROGRESS
): ProgressIndicator = progressIndicator(progress) { }

inline fun LayoutManager<Node>.progressIndicator(
    progress: Number = INDETERMINATE_PROGRESS,
    noinline init: (@LayoutDsl ProgressIndicator).() -> Unit
): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()
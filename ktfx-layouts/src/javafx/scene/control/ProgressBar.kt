@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.control.ProgressBar

/** Create a [ProgressBar] with initialization block. */
inline fun progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar = ProgressBar(progress).apply(init)

/** Add a [ProgressBar] to this manager. */
fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressBar = addNode(ProgressBar(progress))

/** Add a [ProgressBar] with initialization block to this manager. */
inline fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar = addNode(ProgressBar(progress), init)

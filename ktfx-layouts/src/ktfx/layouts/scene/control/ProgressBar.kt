@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS

/** Creates a [ProgressBar]. */
fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress).also {
    init?.invoke(it)
}

/** Creates a [ProgressBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ktfx.layouts.progressBar(progress, init)()

/** Create a styled [ProgressBar]. */
fun styledProgressBar(
    styleClass: String,
    progress: Double = INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ProgressBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledProgressBar(
    styleClass: String,
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ktfx.layouts.styledProgressBar(styleClass, progress, init)()
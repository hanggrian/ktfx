@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator

/** Creates a [ProgressIndicator]. */
fun progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress).also {
    init?.invoke(it)
}

/** Creates a [ProgressIndicator] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = javafxx.layouts.progressIndicator(progress, init)()

/** Create a styled [ProgressIndicator]. */
fun styledProgressIndicator(
    styleClass: String,
    progress: Double = INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ProgressIndicator] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledProgressIndicator(
    styleClass: String,
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = javafxx.layouts.styledProgressIndicator(styleClass, progress, init)()
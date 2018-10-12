@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS

/** Creates a [ProgressBar]. */
fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress).also { init?.invoke(it) }

/** Creates a [ProgressBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ktfx.layouts.progressBar(progress, init)()
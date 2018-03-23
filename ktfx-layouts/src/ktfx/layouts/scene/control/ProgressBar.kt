@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar

inline fun progressBar(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress).apply { init?.invoke(this) }

inline fun Manager<Node>.progressBar(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ProgressBar

inline fun progressBar(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress).apply { init?.invoke(this) }
inline fun ChildManager.progressBar(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
inline fun ItemManager.progressBar(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
inline fun ButtonManager.progressBar(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressBar).() -> Unit)? = null): ProgressBar = ktfx.layouts.progressBar(progress, init).add()
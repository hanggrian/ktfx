@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun progressBar(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@KotfxDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.progressBar(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@KotfxDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.progressBar(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@KotfxDsl ProgressBar).() -> Unit)? = null
): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }.add()
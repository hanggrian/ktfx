@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ProgressIndicator
import javafx.scene.control.ProgressIndicator.INDETERMINATE_PROGRESS
import kotfx.internal.ChildManager
import kotfx.internal.KotfxDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun progressIndicatorOf(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@KotfxDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.progressIndicator(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@KotfxDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.progressIndicator(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@KotfxDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()
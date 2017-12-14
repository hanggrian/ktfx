@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ProgressIndicator
import javafx.scene.control.ProgressIndicator.INDETERMINATE_PROGRESS
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun progressIndicator(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@ControlDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.progressIndicator(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@ControlDsl ProgressIndicator).() -> Unit)? = null
): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()
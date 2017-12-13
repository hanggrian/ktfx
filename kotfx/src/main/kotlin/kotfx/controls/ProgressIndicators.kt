@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ProgressIndicator
import javafx.scene.control.ProgressIndicator.INDETERMINATE_PROGRESS
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _ProgressedIndicator(progress: Double) : ProgressIndicator(progress), _Progressed<ProgressIndicator> {
    override val node: ProgressIndicator get() = this

    override fun progress(value: Number) = setProgress(value.toDouble())
}

@JvmOverloads
inline fun progressIndicatorOf(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@ControlDsl _ProgressedIndicator).() -> Unit)? = null
): ProgressIndicator = _ProgressedIndicator(progress.toDouble()).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.progressIndicator(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@ControlDsl _ProgressedIndicator).() -> Unit)? = null
): ProgressIndicator = progressIndicatorOf(progress, init).add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import kotfx._Pane
import kotfx.internal.ControlDsl

class _ProgressedBar(progress: Double) : ProgressBar(progress), _Progressed<ProgressBar> {
    override val node: ProgressBar get() = this
}

@JvmOverloads
inline fun progressBarOf(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@ControlDsl _ProgressedBar).() -> Unit)? = null
): ProgressBar = _ProgressedBar(progress.toDouble()).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.progressBar(
        progress: Number = INDETERMINATE_PROGRESS,
        noinline init: ((@ControlDsl _ProgressedBar).() -> Unit)? = null
): ProgressBar = progressBarOf(progress, init).add()
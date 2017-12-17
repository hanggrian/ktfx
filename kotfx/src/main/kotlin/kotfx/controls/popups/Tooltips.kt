@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Tooltip
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun tooltipOf(
        text: String? = null,
        noinline init: ((@ControlDsl Tooltip).() -> Unit)? = null
): Tooltip = Tooltip(text).apply { init?.invoke(this) }
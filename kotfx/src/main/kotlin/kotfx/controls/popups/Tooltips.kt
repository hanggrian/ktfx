@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Tooltip
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun tooltipOf(
        text: String? = null,
        noinline init: ((@KotfxDsl Tooltip).() -> Unit)? = null
): Tooltip = Tooltip(text).apply { init?.invoke(this) }
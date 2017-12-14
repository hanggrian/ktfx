@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.control.Tooltip
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun tooltip(
        text: String? = null,
        noinline init: ((@ControlDsl Tooltip).() -> Unit)? = null
): Tooltip = Tooltip(text).apply { init?.invoke(this) }
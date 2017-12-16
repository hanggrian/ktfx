@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@ControlDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@ControlDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }.add()
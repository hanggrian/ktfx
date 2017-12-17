@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun separatorOf(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@ControlDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@ControlDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@ControlDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }.add()
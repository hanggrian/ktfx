@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.control.Separator
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@KotfxDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@KotfxDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.separator(
        orientation: Orientation = HORIZONTAL,
        noinline init: ((@KotfxDsl Separator).() -> Unit)? = null
): Separator = Separator(orientation).apply { init?.invoke(this) }.add()
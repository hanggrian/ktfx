@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun colorPicker(
        color: Color = WHITE,
        noinline init: ((@KotfxDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.colorPicker(
        color: Color = WHITE,
        noinline init: ((@KotfxDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.colorPicker(
        color: Color = WHITE,
        noinline init: ((@KotfxDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()
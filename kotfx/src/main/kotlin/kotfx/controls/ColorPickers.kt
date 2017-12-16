@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun colorPickerOf(
        color: Color = WHITE,
        noinline init: ((@ControlDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.colorPicker(
        color: Color = WHITE,
        noinline init: ((@ControlDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.colorPicker(
        color: Color = WHITE,
        noinline init: ((@ControlDsl ColorPicker).() -> Unit)? = null
): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ColorPicker
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _ColorPicker(color: Color) : ColorPicker(color), _ComboBoxBase<ColorPicker, Color> {
    override val node: ColorPicker get() = this
}

@JvmOverloads
inline fun colorPickerOf(
        color: Color = WHITE,
        noinline init: ((@ControlDsl _ColorPicker).() -> Unit)? = null
): ColorPicker = _ColorPicker(color).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.colorPicker(
        color: Color = WHITE,
        noinline init: ((@ControlDsl _ColorPicker).() -> Unit)? = null
): ColorPicker = colorPickerOf(color, init).add()
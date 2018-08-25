@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ColorPickerStyler
import javafx.scene.control.ColorPicker

fun ColorPicker.aquafx(init: ((ColorPickerStyler) -> Unit)? = null) {
    val styler = ColorPickerStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
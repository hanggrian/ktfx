@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.RadioButtonStyler
import javafx.scene.control.RadioButton

fun RadioButton.aquafx(init: ((RadioButtonStyler) -> Unit)? = null) {
    val styler = RadioButtonStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
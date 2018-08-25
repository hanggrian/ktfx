@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.SliderStyler
import javafx.scene.control.Slider

fun Slider.aquafx(init: ((SliderStyler) -> Unit)? = null) {
    val styler = SliderStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
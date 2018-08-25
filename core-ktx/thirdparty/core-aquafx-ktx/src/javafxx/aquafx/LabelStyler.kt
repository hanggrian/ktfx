@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.LabelStyler
import javafx.scene.control.Label

fun Label.aquafx(init: ((LabelStyler) -> Unit)? = null) {
    val styler = LabelStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
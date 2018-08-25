@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ChoiceBoxStyler
import javafx.scene.control.ChoiceBox

fun ChoiceBox<*>.aquafx(init: ((ChoiceBoxStyler) -> Unit)? = null) {
    val styler = ChoiceBoxStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
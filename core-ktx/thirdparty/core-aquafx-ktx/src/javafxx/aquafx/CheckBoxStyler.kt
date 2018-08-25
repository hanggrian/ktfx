@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.CheckBoxStyler
import javafx.scene.control.CheckBox

fun CheckBox.aquafx(init: ((CheckBoxStyler) -> Unit)? = null) {
    val styler = CheckBoxStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
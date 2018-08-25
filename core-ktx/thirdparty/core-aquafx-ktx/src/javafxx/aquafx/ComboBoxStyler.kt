@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ComboBoxStyler
import javafx.scene.control.ComboBox

fun ComboBox<*>.aquafx(init: ((ComboBoxStyler) -> Unit)? = null) {
    val styler = ComboBoxStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
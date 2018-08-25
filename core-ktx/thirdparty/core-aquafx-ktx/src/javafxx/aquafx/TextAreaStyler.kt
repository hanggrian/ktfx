@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.TextAreaStyler
import javafx.scene.control.TextArea

fun TextArea.aquafx(init: ((TextAreaStyler) -> Unit)? = null) {
    val styler = TextAreaStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
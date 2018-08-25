@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.TextFieldType
import com.aquafx_project.controls.skin.styles.styler.TextFieldStyler
import javafx.scene.control.TextField

inline infix fun TextFieldStyler.type(type: TextFieldType): TextFieldStyler = setType(type)

fun TextField.aquafx(init: ((TextFieldStyler) -> Unit)? = null) {
    val styler = TextFieldStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
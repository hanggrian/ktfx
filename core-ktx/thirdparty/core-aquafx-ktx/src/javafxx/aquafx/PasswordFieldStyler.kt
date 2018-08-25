@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.PasswordFieldStyler
import javafx.scene.control.PasswordField

fun PasswordField.aquafx(init: ((PasswordFieldStyler) -> Unit)? = null) {
    val styler = PasswordFieldStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
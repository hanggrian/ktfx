@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.ButtonType
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons
import com.aquafx_project.controls.skin.styles.styler.ButtonStyler
import javafx.scene.control.Button

inline infix fun ButtonStyler.type(type: ButtonType): ButtonStyler = setType(type)

inline infix fun ButtonStyler.icon(icon: MacOSDefaultIcons): ButtonStyler = setIcon(icon)

fun Button.aquafx(init: ((ButtonStyler) -> Unit)? = null) {
    val styler = ButtonStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
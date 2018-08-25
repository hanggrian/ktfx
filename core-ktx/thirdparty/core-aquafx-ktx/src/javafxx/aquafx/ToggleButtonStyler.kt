@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.ButtonType
import com.aquafx_project.controls.skin.styles.MacOSDefaultIcons
import com.aquafx_project.controls.skin.styles.styler.ToggleButtonStyler
import javafx.scene.control.ToggleButton

inline infix fun ToggleButtonStyler.type(type: ButtonType): ToggleButtonStyler = setType(type)

inline infix fun ToggleButtonStyler.icon(icon: MacOSDefaultIcons): ToggleButtonStyler = setIcon(icon)

fun ToggleButton.aquafx(init: ((ToggleButtonStyler) -> Unit)? = null) {
    val styler = ToggleButtonStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
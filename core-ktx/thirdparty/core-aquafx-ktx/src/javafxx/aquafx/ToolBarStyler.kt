@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ToolBarStyler
import javafx.scene.control.ToolBar

fun ToolBar.aquafx(init: ((ToolBarStyler) -> Unit)? = null) {
    val styler = ToolBarStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
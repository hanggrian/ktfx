@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ScrollBarStyler
import javafx.scene.control.ScrollBar

fun ScrollBar.aquafx(init: ((ScrollBarStyler) -> Unit)? = null) {
    val styler = ScrollBarStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
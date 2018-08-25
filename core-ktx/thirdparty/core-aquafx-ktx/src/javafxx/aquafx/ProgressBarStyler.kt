@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ProgressBarStyler
import javafx.scene.control.ProgressBar

fun ProgressBar.aquafx(init: ((ProgressBarStyler) -> Unit)? = null) {
    val styler = ProgressBarStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
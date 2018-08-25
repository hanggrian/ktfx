@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.styler.ProgressIndicatorStyler
import javafx.scene.control.ProgressIndicator

fun ProgressIndicator.aquafx(init: ((ProgressIndicatorStyler) -> Unit)? = null) {
    val styler = ProgressIndicatorStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
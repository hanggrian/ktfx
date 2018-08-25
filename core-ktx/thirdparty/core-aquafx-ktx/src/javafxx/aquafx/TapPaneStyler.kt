@file:Suppress("NOTHING_TO_INLINE")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.TabPaneType
import com.aquafx_project.controls.skin.styles.styler.TabPaneStyler
import javafx.scene.control.TabPane

inline infix fun TabPaneStyler.type(type: TabPaneType): TabPaneStyler = setType(type)

fun TabPane.aquafx(init: ((TabPaneStyler) -> Unit)? = null) {
    val styler = TabPaneStyler.create()
    init?.invoke(styler)
    styler.style(this)
}
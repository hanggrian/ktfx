@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioButton

inline fun radioButton(
    text: String? = null
): RadioButton = radioButton(text) { }

inline fun radioButton(
    text: String? = null,
    init: (@LayoutDsl RadioButton).() -> Unit
): RadioButton = RadioButton(text).apply(init)

inline fun LayoutManager<Node>.radioButton(
    text: String? = null
): RadioButton = radioButton(text) { }

inline fun LayoutManager<Node>.radioButton(
    text: String? = null,
    init: (@LayoutDsl RadioButton).() -> Unit
): RadioButton = ktfx.layouts.radioButton(text, init).add()
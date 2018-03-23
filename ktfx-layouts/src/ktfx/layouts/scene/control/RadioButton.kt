@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioButton

inline fun radioButton(
    text: String? = null,
    noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).also { init?.invoke(it) }

inline fun LayoutManager<Node>.radioButton(
    text: String? = null,
    noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = ktfx.layouts.radioButton(text, init).add()
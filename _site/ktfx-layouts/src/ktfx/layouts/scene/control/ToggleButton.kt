@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton

inline fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).also { init?.invoke(it) }

inline fun LayoutManager<Node>.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init).add()
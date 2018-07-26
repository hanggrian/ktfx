@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.Tooltip
import javafx.scene.control.Tooltip.install

/** Creates a [Tooltip]. */
fun tooltip(
    text: String? = null,
    init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = Tooltip(text).also {
    init?.invoke(it)
}

/** Creates a [Tooltip] and set it to this [Node]. */
inline fun Node.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = javafxx.layouts.tooltip(text, init).also { install(this, it) }

/** Creates a [Tooltip] and set it to this [Control]. */
inline fun Control.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = javafxx.layouts.tooltip(text, init).also { setTooltip(it) }

/** Creates a [Tooltip] and set it to this [Tab]. */
inline fun Tab.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = javafxx.layouts.tooltip(text, init).also { setTooltip(it) }
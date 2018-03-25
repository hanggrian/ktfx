@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.Tooltip
import javafx.scene.control.Tooltip.install

inline fun tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = Tooltip(text).also { init?.invoke(it) }

inline fun Node.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
) = install(this, ktfx.layouts.tooltip(text, init))

inline fun Control.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
) = setTooltip(ktfx.layouts.tooltip(text, init))

inline fun Tab.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
) = setTooltip(ktfx.layouts.tooltip(text, init))
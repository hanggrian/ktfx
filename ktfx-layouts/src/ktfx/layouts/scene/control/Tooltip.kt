@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.Tooltip
import javafx.scene.control.Tooltip.install

inline fun tooltip(
    text: String? = null
): Tooltip = tooltip(text) { }

inline fun tooltip(
    text: String? = null,
    init: (@LayoutDsl Tooltip).() -> Unit
): Tooltip = Tooltip(text).apply(init)

inline fun Node.tooltip(
    text: String? = null
) = tooltip(text) { }

inline fun Node.tooltip(
    text: String? = null,
    init: (@LayoutDsl Tooltip).() -> Unit
) = install(this, ktfx.layouts.tooltip(text, init))

inline fun Control.tooltip(
    text: String? = null
) = tooltip(text) { }

inline fun Control.tooltip(
    text: String? = null,
    init: (@LayoutDsl Tooltip).() -> Unit
) = setTooltip(ktfx.layouts.tooltip(text, init))

inline fun Tab.tooltip(
    text: String? = null
) = tooltip(text) { }

inline fun Tab.tooltip(
    text: String? = null,
    init: (@LayoutDsl Tooltip).() -> Unit
) = setTooltip(ktfx.layouts.tooltip(text, init))
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.Tooltip
import javafx.scene.control.Tooltip.install
import ktfx.annotations.LayoutDsl

/** Creates a [Tooltip]. */
fun tooltip(
    text: String? = null,
    init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = Tooltip(text).also { init?.invoke(it) }

/** Creates a [Tooltip] and set it to this [Node]. */
inline fun Node.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = ktfx.layouts.tooltip(text, init).also { install(this, it) }

/** Creates a [Tooltip] and set it to this [Control]. */
inline fun Control.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = ktfx.layouts.tooltip(text, init).also { tooltip = it }

/** Creates a [Tooltip] and set it to this [Tab]. */
inline fun Tab.tooltip(
    text: String? = null,
    noinline init: ((@LayoutDsl Tooltip).() -> Unit)? = null
): Tooltip = ktfx.layouts.tooltip(text, init).also { tooltip = it }
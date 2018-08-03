@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

/** Creates a [SeparatorMenuItem]. */
fun separatorMenuItem(
    init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().also {
    init?.invoke(it)
}

/** Creates a [SeparatorMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.separatorMenuItem(
    noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = javafxx.layouts.separatorMenuItem(init)()

/** Create a styled [SeparatorMenuItem]. */
fun styledSeparatorMenuItem(
    styleClass: String,
    init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SeparatorMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.styledSeparatorMenuItem(
    styleClass: String,
    noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = javafxx.layouts.styledSeparatorMenuItem(styleClass, init)()
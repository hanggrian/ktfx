@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import ktfx.MenuItemManager
import ktfx.annotations.LayoutDsl

/** Creates a [CheckMenuItem]. */
fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = CheckMenuItem(text, graphic).also { init?.invoke(it) }

/** Creates a [CheckMenuItem] and add it to this manager. */
inline fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = ktfx.layouts.checkMenuItem(text, graphic, init)()
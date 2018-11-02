@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioMenuItem
import ktfx.MenuItemInvokable
import ktfx.LayoutDsl

/** Creates a [RadioMenuItem]. */
fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).also { init?.invoke(it) }

/** Creates a [RadioMenuItem] and add it to this manager. */
inline fun MenuItemInvokable.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = ktfx.layouts.radioMenuItem(text, graphic, init)()
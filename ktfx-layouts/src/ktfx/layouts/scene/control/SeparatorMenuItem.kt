@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import ktfx.MenuItemInvokable
import ktfx.LayoutDsl

/** Creates a [SeparatorMenuItem]. */
fun separatorMenuItem(
    init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().also { init?.invoke(it) }

/** Creates a [SeparatorMenuItem] and add it to this manager. */
inline fun MenuItemInvokable.separatorMenuItem(
    noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = ktfx.layouts.separatorMenuItem(init)()
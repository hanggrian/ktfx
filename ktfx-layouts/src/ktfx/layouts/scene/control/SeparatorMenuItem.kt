@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem

/** Creates a [SeparatorMenuItem]. */
fun separatorMenuItem(
    init: ((@LayoutMarker SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().also { init?.invoke(it) }

/** Creates a [SeparatorMenuItem] and add it to this manager. */
inline fun MenuItemManager.separatorMenuItem(
    noinline init: ((@LayoutMarker SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = ktfx.layouts.separatorMenuItem(init).add()
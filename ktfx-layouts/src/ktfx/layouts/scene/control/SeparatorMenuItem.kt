@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem

/** Add a [SeparatorMenuItem] to this manager. */
fun MenuItemManager.separatorMenuItem(): SeparatorMenuItem =
    SeparatorMenuItem().add()

/** Add a [SeparatorMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.separatorMenuItem(
    init: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem = separatorMenuItem().apply(init)

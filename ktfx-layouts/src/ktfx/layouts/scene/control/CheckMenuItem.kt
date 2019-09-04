@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem

/** Add a [CheckMenuItem] to this manager. */
fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null
): CheckMenuItem = CheckMenuItem(text, graphic).add()

/** Add a [CheckMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem = checkMenuItem(text, graphic).apply(init)

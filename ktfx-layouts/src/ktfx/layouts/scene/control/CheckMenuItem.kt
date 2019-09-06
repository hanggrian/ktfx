@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem

/** Create a [CheckMenuItem] with initialization block. */
inline fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem = CheckMenuItem(text, graphic).apply(init)

/** Add a [CheckMenuItem] to this manager. */
fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null
): CheckMenuItem = addItem(ktfx.layouts.checkMenuItem(text, graphic) { })

/** Add a [CheckMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem = addItem(ktfx.layouts.checkMenuItem(text, graphic, init))

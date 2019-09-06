@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

open class _MenuButton(text: String?, graphic: Node?) : MenuButton(text, graphic), MenuItemManager {

    override fun <T : MenuItem> addItem(item: T): T = item.also { items + it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [MenuButton] with initialization block. */
inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker _MenuButton).() -> Unit
): MenuButton = _MenuButton(text, graphic).apply(init)

/** Add a [MenuButton] to this manager. */
fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = addNode(ktfx.layouts.menuButton(text, graphic) { })

/** Add a [MenuButton] with initialization block to this manager. */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker _MenuButton).() -> Unit
): MenuButton = addNode(ktfx.layouts.menuButton(text, graphic, init))

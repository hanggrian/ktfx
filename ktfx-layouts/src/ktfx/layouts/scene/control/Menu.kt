@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

open class _Menu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    override fun <R : MenuItem> R.add(): R = also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Add a [Menu] to this manager. */
fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = _Menu(text, graphic).add()

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null,
    init: (@LayoutDslMarker _Menu).() -> Unit
): Menu = (menu(text, graphic) as _Menu).apply(init)

/** Add a [Menu] to this manager. */
fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = _Menu(text, graphic).add()

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    init: (@LayoutDslMarker _Menu).() -> Unit
): Menu = (menu(text, graphic) as _Menu).apply(init)

@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import ktfx.MenuItemManager
import ktfx.annotations.LayoutDsl

open class _Menu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    override val collection: MutableCollection<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [Menu]. */
fun menu(
    text: String = "",
    graphic: Node? = null,
    init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = _Menu(text, graphic).also { init?.invoke(it) }

/** Creates a [Menu] and add it to this manager. */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = ktfx.layouts.menu(text, graphic, init)()
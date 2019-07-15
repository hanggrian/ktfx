@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

open class _Menu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    override fun <R : MenuItem> R.add(): R = also { items += it }

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDslMarker MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [Menu]. */
fun menu(
    text: String = "",
    graphic: Node? = null,
    init: ((@LayoutDslMarker _Menu).() -> Unit)? = null
): Menu = _Menu(text, graphic).also { init?.invoke(it) }

/** Creates a [Menu] and add it to this manager. */
inline fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker _Menu).() -> Unit)? = null
): Menu = ktfx.layouts.menu(text, graphic, init).add()

/** Creates a [Menu] and add it to this manager. */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker _Menu).() -> Unit)? = null
): Menu = ktfx.layouts.menu(text, graphic, init).add()

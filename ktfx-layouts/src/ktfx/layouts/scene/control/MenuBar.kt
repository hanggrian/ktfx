@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import ktfx.MenuManager
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _MenuBar(vararg menus: Menu) : MenuBar(*menus), MenuManager {

    /** Creates a [Menu] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        vararg items: MenuItem,
        noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
    ): Menu = menu(this, graphic, *items, init = init)()
}

/** Creates a [MenuBar]. */
fun menuBar(
    vararg menus: Menu,
    init: ((@LayoutDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).also { init?.invoke(it) }

/** Creates a [MenuBar] and add it to this manager. */
inline fun NodeManager.menuBar(
    vararg menus: Menu,
    noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null
): MenuBar = ktfx.layouts.menuBar(*menus, init = init)()
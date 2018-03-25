@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

@Suppress("ClassName")
open class _Menu(text: String, graphic: Node?, vararg items: MenuItem) : Menu(text, graphic, *items), LayoutManager<MenuItem> {

    override fun <T : MenuItem> T.add(): T = also { items += it }
}

inline fun menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = _Menu(text, graphic, *items).also { init?.invoke(it) }

inline fun LayoutManager<MenuItem>.menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = ktfx.layouts.menu(text, graphic, *items, init = init).add()
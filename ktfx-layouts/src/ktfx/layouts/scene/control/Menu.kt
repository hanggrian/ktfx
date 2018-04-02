@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

@Suppress("ClassName")
open class _Menu(text: String, graphic: Node?, vararg items: MenuItem) : Menu(text, graphic, *items), LayoutManager<MenuItem> {

    override val childs: ObservableList<MenuItem> get() = items
}

inline fun menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem
): Menu = menu(text, graphic, *items) { }

inline fun menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    init: (@LayoutDsl _Menu).() -> Unit
): Menu = _Menu(text, graphic, *items).apply(init)

inline fun LayoutManager<MenuItem>.menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem
): Menu = menu(text, graphic, *items) { }

inline fun LayoutManager<MenuItem>.menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    init: (@LayoutDsl _Menu).() -> Unit
): Menu = ktfx.layouts.menu(text, graphic, *items, init = init).add()
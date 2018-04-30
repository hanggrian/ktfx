@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

open class _Menu(
    text: String,
    graphic: Node?,
    vararg items: MenuItem
) : Menu(text, graphic, *items), LayoutManager<MenuItem> {

    override val childs: MutableList<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)

    /** Creates a styled [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = styledMenuItem(styleClass, this, graphic, init)
}

/** Creates a [Menu]. */
fun menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = _Menu(text, graphic, *items).also {
    init?.invoke(it)
}

/** Creates a [Menu] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.menu(
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = ktfx.layouts.menu(text, graphic, *items, init = init).add()

/** Create a styled [Menu]. */
fun styledMenu(
    styleClass: String,
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = _Menu(text, graphic, *items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Menu] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.styledMenu(
    styleClass: String,
    text: String = "",
    graphic: Node? = null,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
): Menu = ktfx.layouts.styledMenu(styleClass, text, graphic, *items, init = init).add()
@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

open class _MenuButton(
    text: String?,
    graphic: Node?,
    vararg items: MenuItem
) : MenuButton(text, graphic, *items), LayoutManager<MenuItem> {

    override val childs: ObservableList<MenuItem> get() = items

    /** Convenient method to add item to this menu by only using string. */
    inline operator fun String.invoke(graphic: Node? = null): MenuItem = invoke(graphic) { }

    /** Convenient method to add item to this menu by only using string. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDsl MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

inline fun menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = menuButton(text, graphic) { }

inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl _MenuButton).() -> Unit
): MenuButton = _MenuButton(text, graphic).apply(init)

inline fun LayoutManager<Node>.menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = menuButton(text, graphic) { }

inline fun LayoutManager<Node>.menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl _MenuButton).() -> Unit
): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()
@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

open class _SplitMenuButton(vararg items: MenuItem) : SplitMenuButton(*items),
    LayoutManager<MenuItem> {

    override val childs: ObservableList<MenuItem> get() = items

    /** Convenient method to add item to this menu by only using string. */
    inline operator fun String.invoke(graphic: Node? = null): MenuItem = invoke(graphic) { }

    /** Convenient method to add item to this menu by only using string. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDsl MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

inline fun splitMenuButton(
    vararg items: MenuItem
): SplitMenuButton = splitMenuButton(*items) { }

inline fun splitMenuButton(
    vararg items: MenuItem,
    init: (@LayoutDsl _SplitMenuButton).() -> Unit
): SplitMenuButton = _SplitMenuButton(*items).apply(init)

inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem
): SplitMenuButton = splitMenuButton(*items) { }

inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem,
    init: (@LayoutDsl _SplitMenuButton).() -> Unit
): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init).add()
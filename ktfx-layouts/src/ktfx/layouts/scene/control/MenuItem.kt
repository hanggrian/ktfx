@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem

inline fun menuItem(
    text: String? = null,
    graphic: Node? = null
): MenuItem = menuItem(text, graphic) { }

inline fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl MenuItem).() -> Unit
): MenuItem = MenuItem(text, graphic).apply(init)

inline fun LayoutManager<MenuItem>.menuItem(
    text: String? = null,
    graphic: Node? = null
): MenuItem = menuItem(text, graphic) { }

inline fun LayoutManager<MenuItem>.menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl MenuItem).() -> Unit
): MenuItem = ktfx.layouts.menuItem(text, graphic, init).add()
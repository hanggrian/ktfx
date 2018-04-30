@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem

/** Creates a [MenuItem]. */
fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [MenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.menuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
): MenuItem = ktfx.layouts.menuItem(text, graphic, init).add()

/** Create a styled [MenuItem]. */
fun styledMenuItem(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.styledMenuItem(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
): MenuItem = ktfx.layouts.styledMenuItem(styleClass, text, graphic, init).add()
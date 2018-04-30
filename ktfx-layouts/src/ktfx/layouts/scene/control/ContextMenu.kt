@file:Suppress("NOTHING_TO_INLINE", "ClassName", "UsePropertyAccessSyntax")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase

open class _ContextMenu(
    vararg items: MenuItem
) : ContextMenu(*items), LayoutManager<MenuItem> {

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

/** Creates a [ContextMenu]. */
fun contextMenu(
    vararg items: MenuItem,
    init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = _ContextMenu(*items).also {
    init?.invoke(it)
}

/** Creates a [ContextMenu] and set it to this [Control]. */
inline fun Control.contextMenu(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(*items, init = init).also { setContextMenu(it) }

/** Creates a [ContextMenu] and set it to this [Tab]. */
inline fun Tab.contextMenu(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(*items, init = init).also { setContextMenu(it) }

/** Creates a [ContextMenu] and set it to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.contextMenu(*items, init = init).also { setContextMenu(it) }

/** Creates a styled [ContextMenu]. */
fun styledContextMenu(
    styleClass: String,
    vararg items: MenuItem,
    init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = _ContextMenu(*items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ContextMenu] and set it to this [Control]. */
inline fun Control.styledContextMenu(
    styleClass: String,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.styledContextMenu(styleClass, *items, init = init).also { setContextMenu(it) }

/** Creates a styled [ContextMenu] and set it to this [Tab]. */
inline fun Tab.styledContextMenu(
    styleClass: String,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.styledContextMenu(styleClass, *items, init = init).also { setContextMenu(it) }

/** Creates a styled [ContextMenu] and set it to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.styledContextMenu(
    styleClass: String,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _ContextMenu).() -> Unit)? = null
): ContextMenu = ktfx.layouts.styledContextMenu(styleClass, *items, init = init).also { setContextMenu(it) }
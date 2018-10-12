@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

open class _MenuButton(
    text: String?,
    graphic: Node?,
    vararg items: MenuItem
) : MenuButton(text, graphic, *items), LayoutManager<MenuItem> {

    override val childs: MutableCollection<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [MenuButton]. */
fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl _MenuButton).() -> Unit)? = null
): MenuButton = _MenuButton(text, graphic).also { init?.invoke(it) }

/** Creates a [MenuButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.menuButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl _MenuButton).() -> Unit)? = null
): MenuButton = ktfx.layouts.menuButton(text, graphic, init)()
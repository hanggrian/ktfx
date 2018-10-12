@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

open class _SplitMenuButton(
    vararg items: MenuItem
) : SplitMenuButton(*items), LayoutManager<MenuItem> {

    override val childs: MutableCollection<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [SplitMenuButton]. */
fun splitMenuButton(
    vararg items: MenuItem,
    init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = _SplitMenuButton(*items).also { init?.invoke(it) }

/** Creates a [SplitMenuButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = ktfx.layouts.splitMenuButton(*items, init = init)()
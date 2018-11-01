@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton
import ktfx.MenuItemManager
import ktfx.NodeManager
import ktfx.LayoutDsl

open class _SplitMenuButton : SplitMenuButton(), MenuItemManager {

    override val collection: MutableCollection<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this manager. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)
}

/** Creates a [SplitMenuButton]. */
fun splitMenuButton(
    init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = _SplitMenuButton().also { init?.invoke(it) }

/** Creates a [SplitMenuButton] and add it to this manager. */
inline fun NodeManager.splitMenuButton(
    noinline init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = ktfx.layouts.splitMenuButton(init)()
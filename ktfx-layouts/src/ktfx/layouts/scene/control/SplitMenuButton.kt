@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

open class _SplitMenuButton : SplitMenuButton(), MenuItemManager {

    override fun <T : MenuItem> addItem(item: T): T = item.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [SplitMenuButton] with initialization block. */
inline fun splitMenuButton(
    init: (@LayoutDslMarker _SplitMenuButton).() -> Unit
): SplitMenuButton = _SplitMenuButton().apply(init)

/** Add a [SplitMenuButton] to this manager. */
fun NodeManager.splitMenuButton(): SplitMenuButton =
    addNode(ktfx.layouts.splitMenuButton { })

/** Add a [SplitMenuButton] with initialization block to this manager. */
inline fun NodeManager.splitMenuButton(
    init: (@LayoutDslMarker _SplitMenuButton).() -> Unit
): SplitMenuButton = addNode(ktfx.layouts.splitMenuButton(init))

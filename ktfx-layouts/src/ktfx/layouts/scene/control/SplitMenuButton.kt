@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

open class KtfxSplitMenuButton : SplitMenuButton(), MenuItemManager {

    final override fun <T : MenuItem> addItem(item: T): T =
        item.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [SplitMenuButton] with initialization block. */
inline fun splitMenuButton(
    init: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton = KtfxSplitMenuButton().apply(init)

/** Add a [SplitMenuButton] to this manager. */
fun NodeManager.splitMenuButton(): SplitMenuButton =
    addNode(KtfxSplitMenuButton())

/** Add a [SplitMenuButton] with initialization block to this manager. */
inline fun NodeManager.splitMenuButton(
    init: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton = addNode(KtfxSplitMenuButton(), init)

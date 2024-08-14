@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem

/**
 * [ContextMenu] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxContextMenu :
    ContextMenu(),
    MenuItemContainer {
    final override fun <T : MenuItem> addChild(child: T): T = child.also { items += it }

    /** Call [MenuItemContainer.menuItem] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        noinline configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
    ): MenuItem = menuItem(this, graphic, configuration)
}

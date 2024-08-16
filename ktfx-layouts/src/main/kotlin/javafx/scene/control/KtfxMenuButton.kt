@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

/**
 * [MenuButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxMenuButton(text: String?, graphic: Node?) :
    MenuButton(text, graphic),
    MenuItemContainer {
    final override fun <T : MenuItem> addChild(child: T): T = child.also { items + it }

    /** Call [MenuItemContainer.menuItem] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
    ): MenuItem = menuItem(this, graphic, configuration)
}

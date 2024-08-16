@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

/**
 * [SplitMenuButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxSplitMenuButton :
    SplitMenuButton(),
    MenuItemContainer {
    final override fun <T : MenuItem> addChild(child: T): T = child.also { items += it }

    /** Call [MenuItemContainer.menuItem] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
    ): MenuItem = menuItem(this, graphic, configuration)
}

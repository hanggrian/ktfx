@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts

/**
 * [Menu] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenu(text: String, graphic: Node?) :
    Menu(text, graphic),
    MenuItemContainer {
    final override fun <T : MenuItem> addChild(child: T): T = child.also { items += it }

    /** Call [MenuItemContainer.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker MenuItem).() -> Unit,
    ): MenuItem = menuItem(this, graphic, configuration)
}

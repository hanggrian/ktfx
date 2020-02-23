@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts

/**
 * [MenuButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenuButton(text: String?, graphic: Node?) : MenuButton(text, graphic), MenuItemManager {

    final override fun <C : MenuItem> addChild(child: C): C = child.also { items + it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, configuration)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts

/**
 * [Menu] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    final override fun <C : MenuItem> addChild(child: C): C = child.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, configuration)
}

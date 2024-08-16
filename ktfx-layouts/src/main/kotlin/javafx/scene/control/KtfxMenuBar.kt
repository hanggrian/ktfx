@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

/**
 * [MenuBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxMenuBar :
    MenuBar(),
    MenuContainer {
    final override fun <T : Menu> addChild(child: T): T = child.also { menus += it }

    /** Call [MenuContainer.menu] by string invocation. */
    public inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
    ): Menu = menu(this, graphic, configuration)
}

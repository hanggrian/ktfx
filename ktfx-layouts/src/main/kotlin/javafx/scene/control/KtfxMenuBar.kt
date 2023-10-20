@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotlin.contracts.ExperimentalContracts

/**
 * [MenuBar] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenuBar : MenuBar(), MenuContainer {
    final override fun <T : Menu> addChild(child: T): T = child.also { menus += it }

    /** Call [MenuContainer.menu] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker KtfxMenu).() -> Unit,
    ): Menu = menu(this, graphic, configuration)
}

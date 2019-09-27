@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

open class KtfxMenuBar : MenuBar(), MenuManager {

    override fun <T : Menu> addMenu(menu: T): T = menu.also { menus += it }

    /** Call [MenuManager.menu] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker KtfxMenu).() -> Unit
    ): Menu = menu(this, graphic, init)
}

/** Create a [MenuBar] with initialization block. */
inline fun menuBar(
    init: (@LayoutDslMarker KtfxMenuBar).() -> Unit
): MenuBar = KtfxMenuBar().apply(init)

/** Add a [MenuBar] to this manager. */
fun NodeManager.menuBar(): MenuBar =
    addNode(ktfx.layouts.menuBar { })

/** Add a [MenuBar] with initialization block to this manager. */
inline fun NodeManager.menuBar(
    init: (@LayoutDslMarker KtfxMenuBar).() -> Unit
): MenuBar = addNode(ktfx.layouts.menuBar(init))

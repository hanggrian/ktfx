@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

open class _MenuBar : MenuBar(), MenuManager {

    override fun <T : Menu> addMenu(menu: T): T = menu.also { menus += it }

    /** Call [MenuManager.menu] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker _Menu).() -> Unit
    ): Menu = menu(this, graphic, init)
}

/** Create a [MenuBar] with initialization block. */
inline fun menuBar(
    init: (@LayoutDslMarker _MenuBar).() -> Unit
): MenuBar = _MenuBar().apply(init)

/** Add a [MenuBar] to this manager. */
fun NodeManager.menuBar(): MenuBar =
    addNode(ktfx.layouts.menuBar { })

/** Add a [MenuBar] with initialization block to this manager. */
inline fun NodeManager.menuBar(
    init: (@LayoutDslMarker _MenuBar).() -> Unit
): MenuBar = addNode(ktfx.layouts.menuBar(init))

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem

open class KtfxMenu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    final override fun <T : MenuItem> addItem(item: T): T =
        item.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [Menu] with initialization block. */
inline fun menu(
    text: String = "",
    graphic: Node? = null,
    init: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu = KtfxMenu(text, graphic).apply(init)

/** Add a [Menu] to this manager. */
fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = addMenu(KtfxMenu(text, graphic))

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null,
    init: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu = addMenu(KtfxMenu(text, graphic), init)

/** Add a [Menu] to this manager. */
fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = addItem(KtfxMenu(text, graphic))

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    init: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu = addItem(KtfxMenu(text, graphic), init)

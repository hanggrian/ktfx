@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem

open class KtfxMenuButton(text: String?, graphic: Node?) : MenuButton(text, graphic), MenuItemManager {

    final override fun <T : MenuItem> addItem(item: T): T =
        item.also { items + it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [MenuButton] with initialization block. */
inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton = KtfxMenuButton(text, graphic).apply(init)

/** Add a [MenuButton] to this manager. */
fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = addNode(KtfxMenuButton(text, graphic))

/** Add a [MenuButton] with initialization block to this manager. */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton = addNode(KtfxMenuButton(text, graphic), init)

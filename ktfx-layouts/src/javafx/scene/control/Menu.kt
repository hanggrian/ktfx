@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxMenu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    final override fun <T : MenuItem> addItem(item: T): T =
        item.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: MenuItem.() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [Menu] with initialization block. */
inline fun menu(
    text: String = "",
    graphic: Node? = null,
    init: KtfxMenu.() -> Unit
): Menu {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxMenu(text, graphic).apply(init)
}
/** Add a [Menu] to this manager. */
fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = addMenu(KtfxMenu(text, graphic))

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null,
    init: KtfxMenu.() -> Unit
): Menu {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addMenu(KtfxMenu(text, graphic), init)
}
/** Add a [Menu] to this manager. */
fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = addItem(KtfxMenu(text, graphic))

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    init: KtfxMenu.() -> Unit
): Menu {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addItem(KtfxMenu(text, graphic), init)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxMenuBar : MenuBar(), MenuManager {

    final override fun <T : Menu> addMenu(menu: T): T =
        menu.also { menus += it }

    /** Call [MenuManager.menu] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: KtfxMenu.() -> Unit
    ): Menu = menu(this, graphic, init)
}

/** Create a [MenuBar] with initialization block. */
inline fun menuBar(
    init: KtfxMenuBar.() -> Unit
): MenuBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxMenuBar().apply(init) }

/** Add a [MenuBar] to this manager. */
fun NodeManager.menuBar(): MenuBar =
    addNode(KtfxMenuBar())

/** Add a [MenuBar] with initialization block to this manager. */
inline fun NodeManager.menuBar(
    init: KtfxMenuBar.() -> Unit
): MenuBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxMenuBar(), init)
}

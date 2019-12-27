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

/**
 * [Menu] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenu(text: String, graphic: Node?) : Menu(text, graphic), MenuItemManager {

    final override fun <C : MenuItem> addChild(child: C): C = child.also { items += it }

    final override val childCount: Int get() = items.size

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutsDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, configuration)
}

/** Create a [Menu] with initialization block. */
inline fun menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@LayoutsDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxMenu(text, graphic).apply(configuration)
}

/** Add a [Menu] to this manager. */
fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = addChild(KtfxMenu(text, graphic))

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@LayoutsDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxMenu(text, graphic), configuration)
}

/** Add a [Menu] to this manager. */
fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null
): Menu = addChild(KtfxMenu(text, graphic))

/** Add a [Menu] with initialization block to this manager. */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@LayoutsDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxMenu(text, graphic), configuration)
}

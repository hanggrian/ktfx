@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [MenuButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxMenuButton(text: String?, graphic: Node?) : MenuButton(text, graphic), MenuItemManager {

    final override fun <C : MenuItem> addChild(child: C): C = child.also { items + it }

    final override val childCount: Int get() = items.size

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: (@LayoutsDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [MenuButton] with initialization block. */
inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutsDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxMenuButton(text, graphic).apply(init)
}

/** Add a [MenuButton] to this manager. */
fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = addChild(KtfxMenuButton(text, graphic))

/** Add a [MenuButton] with initialization block to this manager. */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutsDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxMenuButton(text, graphic), init)
}

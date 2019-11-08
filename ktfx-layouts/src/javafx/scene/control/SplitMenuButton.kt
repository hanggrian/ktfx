@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

open class KtfxSplitMenuButton : SplitMenuButton(), MenuItemManager {

    final override fun <T : MenuItem> addItem(item: T): T =
        item.also { items += it }

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        init: MenuItem.() -> Unit
    ): MenuItem = menuItem(this, graphic, init)
}

/** Create a [SplitMenuButton] with initialization block. */
inline fun splitMenuButton(
    init: KtfxSplitMenuButton.() -> Unit
): SplitMenuButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxSplitMenuButton().apply(init)
}
/** Add a [SplitMenuButton] to this manager. */
fun NodeManager.splitMenuButton(): SplitMenuButton =
    addNode(KtfxSplitMenuButton())

/** Add a [SplitMenuButton] with initialization block to this manager. */
inline fun NodeManager.splitMenuButton(
    init: KtfxSplitMenuButton.() -> Unit
): SplitMenuButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxSplitMenuButton(), init)
}

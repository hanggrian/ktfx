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

/**
 * [SplitMenuButton] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxSplitMenuButton : SplitMenuButton(), MenuItemManager {

    final override fun <C : MenuItem> addChild(child: C): C = child.also { items += it }

    final override val childCount: Int get() = items.size

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutsDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, configuration)
}

/** Create a [SplitMenuButton] with initialization block. */
inline fun splitMenuButton(
    configuration: (@LayoutsDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSplitMenuButton().apply(configuration)
}

/** Add a [SplitMenuButton] to this manager. */
fun NodeManager.splitMenuButton(): SplitMenuButton = addChild(KtfxSplitMenuButton())

/** Add a [SplitMenuButton] with initialization block to this manager. */
inline fun NodeManager.splitMenuButton(
    configuration: (@LayoutsDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxSplitMenuButton(), configuration)
}

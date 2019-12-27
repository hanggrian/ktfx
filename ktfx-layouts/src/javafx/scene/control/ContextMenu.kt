@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [ContextMenu] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxContextMenu : ContextMenu(), MenuItemManager {

    final override fun <C : MenuItem> addChild(child: C): C = child.also { items += it }

    final override val childCount: Int get() = items.size

    /** Call [MenuItemManager.menuItem] by string invocation. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        configuration: (@LayoutsDslMarker MenuItem).() -> Unit
    ): MenuItem = menuItem(this, graphic, configuration)
}

/** Create a [ContextMenu] with initialization block. */
inline fun contextMenu(
    configuration: (@LayoutsDslMarker KtfxContextMenu).() -> Unit
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxContextMenu().apply(configuration)
}

/** Set a [ContextMenu] to this [Control]. */
fun Control.contextMenu(): ContextMenu =
    KtfxContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [Control]. */
inline fun Control.contextMenu(
    configuration: (@LayoutsDslMarker KtfxContextMenu).() -> Unit
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.contextMenu(configuration).also { contextMenu = it }
}

/** Set a [ContextMenu] to this [Tab]. */
fun Tab.contextMenu(): ContextMenu =
    KtfxContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [Tab]. */
inline fun Tab.contextMenu(
    configuration: (@LayoutsDslMarker KtfxContextMenu).() -> Unit
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.contextMenu(configuration).also { contextMenu = it }
}

/** Set a [ContextMenu] to this [TableColumnBase]. */
fun <S, T> TableColumnBase<S, T>.contextMenu(): ContextMenu =
    ktfx.layouts.contextMenu { }.also { contextMenu = it }

/** Set a [ContextMenu] with initialization block to this [TableColumnBase]. */
inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    configuration: (@LayoutsDslMarker KtfxContextMenu).() -> Unit
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.contextMenu(configuration).also { contextMenu = it }
}

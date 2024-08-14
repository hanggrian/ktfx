@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.TableColumnBase
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ContextMenu] with configuration block. */
public inline fun contextMenu(
    configuration: (@KtfxLayoutDslMarker KtfxContextMenu).() -> Unit,
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxContextMenu().apply(configuration)
}

/** Set a [ContextMenu] to this [Control]. */
public fun Control.contextMenu(): ContextMenu = KtfxContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with configuration block to this [Control]. */
public inline fun Control.contextMenu(
    configuration: (@KtfxLayoutDslMarker KtfxContextMenu).() -> Unit,
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.contextMenu(configuration).also { contextMenu = it }
}

/** Set a [ContextMenu] to this [Tab]. */
public fun Tab.contextMenu(): ContextMenu = KtfxContextMenu().also { contextMenu = it }

/** Set a [ContextMenu] with configuration block to this [Tab]. */
public inline fun Tab.contextMenu(
    configuration: (@KtfxLayoutDslMarker KtfxContextMenu).() -> Unit,
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.contextMenu(configuration).also { contextMenu = it }
}

/** Set a [ContextMenu] to this [TableColumnBase]. */
public fun <S, T> TableColumnBase<S, T>.contextMenu(): ContextMenu =
    ktfx.layouts.contextMenu { }.also { contextMenu = it }

/** Set a [ContextMenu] with configuration block to this [TableColumnBase]. */
public inline fun <S, T> TableColumnBase<S, T>.contextMenu(
    configuration: (@KtfxLayoutDslMarker KtfxContextMenu).() -> Unit,
): ContextMenu {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.contextMenu(configuration).also { contextMenu = it }
}

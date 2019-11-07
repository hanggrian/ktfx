@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [CustomMenuItem] with initialization block. */
inline fun customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CustomMenuItem(node, hideOnClick).apply(init)
}
/** Add a [CustomMenuItem] to this manager. */
fun MenuItemManager.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true
): CustomMenuItem = addItem(CustomMenuItem(node, hideOnClick))

/** Add a [CustomMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.customMenuItem(
    node: Node? = null,
    hideOnClick: Boolean = true,
    init: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addItem(CustomMenuItem(node, hideOnClick), init)
}

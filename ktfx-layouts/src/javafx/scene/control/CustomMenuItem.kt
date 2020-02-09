@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CustomMenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [CustomMenuItem] with configurationialization block. */
inline fun customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    configuration: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CustomMenuItem(content, hideOnClick).apply(configuration)
}

/** Add a [CustomMenuItem] to this manager. */
fun MenuItemManager.customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true
): CustomMenuItem = addChild(CustomMenuItem(content, hideOnClick))

/** Add a [CustomMenuItem] with configurationialization block to this manager. */
inline fun MenuItemManager.customMenuItem(
    content: Node? = null,
    hideOnClick: Boolean = true,
    configuration: (@LayoutDslMarker CustomMenuItem).() -> Unit
): CustomMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(CustomMenuItem(content, hideOnClick), configuration)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MenuItem] with initialization block. */
inline fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: MenuItem.() -> Unit
): MenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return MenuItem(text, graphic).apply(init)
}

/** Add a [MenuItem] to this manager. */
fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null
): MenuItem = addItem(MenuItem(text, graphic))

/** Add a [MenuItem] with initialization block to this manager. */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    init: MenuItem.() -> Unit
): MenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addItem(MenuItem(text, graphic), init)
}

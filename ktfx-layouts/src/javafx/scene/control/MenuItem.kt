@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MenuItem] with configuration block. */
inline fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return MenuItem(text, graphic).apply(configuration)
}

/** Add a [MenuItem] to this manager. */
fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null
): MenuItem = addChild(MenuItem(text, graphic))

/** Add a [MenuItem] with configuration block to this manager. */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(MenuItem(text, graphic), configuration)
}

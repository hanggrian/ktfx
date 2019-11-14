@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [CheckMenuItem] with initialization block. */
inline fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: CheckMenuItem.() -> Unit
): CheckMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return CheckMenuItem(text, graphic).apply(init)
}

/** Add a [CheckMenuItem] to this manager. */
fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null
): CheckMenuItem = addItem(CheckMenuItem(text, graphic))

/** Add a [CheckMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: CheckMenuItem.() -> Unit
): CheckMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addItem(CheckMenuItem(text, graphic), init)
}

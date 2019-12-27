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
    configuration: (@LayoutsDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CheckMenuItem(text, graphic).apply(configuration)
}

/** Add a [CheckMenuItem] to this manager. */
fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null
): CheckMenuItem = addChild(CheckMenuItem(text, graphic))

/** Add a [CheckMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutsDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(CheckMenuItem(text, graphic), configuration)
}

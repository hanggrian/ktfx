@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [SeparatorMenuItem] with initialization block. */
inline fun separatorMenuItem(
    init: (@LayoutsDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return SeparatorMenuItem().apply(init)
}

/** Add a [SeparatorMenuItem] to this manager. */
fun MenuItemManager.separatorMenuItem(): SeparatorMenuItem =
    addItem(SeparatorMenuItem())

/** Add a [SeparatorMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.separatorMenuItem(
    init: (@LayoutsDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addItem(SeparatorMenuItem(), init)
}

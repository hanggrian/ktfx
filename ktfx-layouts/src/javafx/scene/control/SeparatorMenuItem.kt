@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [SeparatorMenuItem] with configuration block. */
inline fun separatorMenuItem(
    configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return SeparatorMenuItem().apply(configuration)
}

/** Add a [SeparatorMenuItem] to this manager. */
fun MenuItemManager.separatorMenuItem(): SeparatorMenuItem = addChild(SeparatorMenuItem())

/** Add a [SeparatorMenuItem] with configuration block to this manager. */
inline fun MenuItemManager.separatorMenuItem(
    configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(SeparatorMenuItem(), configuration)
}

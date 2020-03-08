@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.MaskerPane

/** Create a [MaskerPane] with configuration block. */
inline fun maskerPane(
    configuration: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return MaskerPane().apply(configuration)
}

/** Add a [MaskerPane] to this manager. */
fun NodeManager.maskerPane(): MaskerPane = addChild(MaskerPane())

/** Add a [MaskerPane] with configuration block to this manager. */
inline fun NodeManager.maskerPane(
    configuration: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(MaskerPane(), configuration)
}

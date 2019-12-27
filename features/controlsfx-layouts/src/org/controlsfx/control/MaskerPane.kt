@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.MaskerPane

/** Create a [MaskerPane] with initialization block. */
inline fun maskerPane(
    configuration: (@LayoutsDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return MaskerPane().apply(configuration)
}

/** Add a [MaskerPane] to this manager. */
fun NodeManager.maskerPane(): MaskerPane = addChild(MaskerPane())

/** Add a [MaskerPane] with initialization block to this manager. */
inline fun NodeManager.maskerPane(
    configuration: (@LayoutsDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(MaskerPane(), configuration)
}

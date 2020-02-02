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
    init: (@LayoutsDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return MaskerPane().apply(init)
}

/** Add a [MaskerPane] to this manager. */
fun NodeManager.maskerPane(): MaskerPane = addChild(MaskerPane())

/** Add a [MaskerPane] with initialization block to this manager. */
inline fun NodeManager.maskerPane(
    init: (@LayoutsDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(MaskerPane(), init)
}

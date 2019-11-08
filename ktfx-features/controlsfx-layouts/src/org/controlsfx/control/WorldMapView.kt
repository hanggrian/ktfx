@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.WorldMapView

/** Create a [WorldMapView] with initialization block. */
inline fun worldMapView(
    init: WorldMapView.() -> Unit
): WorldMapView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return WorldMapView().apply(init)
}
/** Add a [WorldMapView] to this manager. */
fun NodeManager.worldMapView(): WorldMapView =
    addNode(WorldMapView())

/** Add a [WorldMapView] with initialization block to this manager. */
inline fun NodeManager.worldMapView(
    init: WorldMapView.() -> Unit
): WorldMapView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(WorldMapView(), init)
}

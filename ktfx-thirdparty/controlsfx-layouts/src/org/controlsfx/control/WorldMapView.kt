@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.thirdparty.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.WorldMapView

/** Create a [WorldMapView] with initialization block. */
inline fun worldMapView(
    init: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView = WorldMapView().apply(init)

/** Add a [WorldMapView] to this manager. */
fun NodeManager.worldMapView(): WorldMapView =
    addNode(WorldMapView())

/** Add a [WorldMapView] with initialization block to this manager. */
inline fun NodeManager.worldMapView(
    init: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView = addNode(WorldMapView(), init)

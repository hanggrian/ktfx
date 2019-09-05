@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.WorldMapView

/** Add a [WorldMapView] to this manager. */
fun NodeManager.worldMapView(): WorldMapView =
    WorldMapView().add()

/** Add a [WorldMapView] with initialization block to this manager. */
inline fun NodeManager.worldMapView(
    init: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView = worldMapView().apply(init)

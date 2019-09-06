@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.WorldMapView

/** Create a [WorldMapView] with initialization block. */
inline fun worldMapView(
    init: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView = WorldMapView().apply(init)

/** Add a [WorldMapView] to this manager. */
fun NodeManager.worldMapView(): WorldMapView =
    addNode(ktfx.controlsfx.worldMapView { })

/** Add a [WorldMapView] with initialization block to this manager. */
inline fun NodeManager.worldMapView(
    init: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView = addNode(ktfx.controlsfx.worldMapView(init))

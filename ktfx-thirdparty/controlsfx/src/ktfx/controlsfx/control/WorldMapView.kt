@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker
import org.controlsfx.control.WorldMapView

/** Creates a [WorldMapView]. */
fun worldMapView(
    init: ((@LayoutMarker WorldMapView).() -> Unit)? = null
): WorldMapView = WorldMapView().also { init?.invoke(it) }

/** Creates a [WorldMapView] and add it to this manager. */
inline fun NodeManager.worldMapView(
    noinline init: ((@LayoutMarker WorldMapView).() -> Unit)? = null
): WorldMapView = ktfx.controlsfx.worldMapView(init).add()
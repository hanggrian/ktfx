@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.WorldMapView

/** Creates a [WorldMapView]. */
fun worldMapView(
    init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = WorldMapView().also { init?.invoke(it) }

/** Creates a [WorldMapView] and add it to this manager. */
inline fun NodeManager.worldMapView(
    noinline init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = ktfx.controlsfx.worldMapView(init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.WorldMapView

/** Creates a [WorldMapView]. */
fun worldMapView(
    init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = WorldMapView().also { init?.invoke(it) }

/** Creates a [WorldMapView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.worldMapView(
    noinline init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = ktfx.controlsfx.worldMapView(init)()
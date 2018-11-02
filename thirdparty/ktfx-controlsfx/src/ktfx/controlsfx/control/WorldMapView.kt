@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.NodeInvokable
import ktfx.LayoutDsl
import org.controlsfx.control.WorldMapView

/** Creates a [WorldMapView]. */
fun worldMapView(
    init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = WorldMapView().also { init?.invoke(it) }

/** Creates a [WorldMapView] and add it to this manager. */
inline fun NodeInvokable.worldMapView(
    noinline init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = ktfx.controlsfx.worldMapView(init)()
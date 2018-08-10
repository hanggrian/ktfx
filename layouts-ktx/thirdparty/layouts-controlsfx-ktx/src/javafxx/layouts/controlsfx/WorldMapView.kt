@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.WorldMapView

/** Creates a [WorldMapView]. */
fun worldMapView(
    init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = WorldMapView().also {
    init?.invoke(it)
}

/** Creates a [WorldMapView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.worldMapView(
    noinline init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = javafxx.layouts.controlsfx.worldMapView(init)()

/** Create a styled [WorldMapView]. */
fun styledWorldMapView(
    styleClass: String,
    init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = WorldMapView().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [WorldMapView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledWorldMapView(
    styleClass: String,
    noinline init: ((@LayoutDsl WorldMapView).() -> Unit)? = null
): WorldMapView = javafxx.layouts.controlsfx.styledWorldMapView(styleClass, init)()
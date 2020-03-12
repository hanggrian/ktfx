@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.WorldMapView

/**
 * Add a [WorldMapView] to this manager.
 */
fun NodeManager.worldMapView(): WorldMapView = worldMapView() { }

/**
 * Create a [WorldMapView] with configuration block.
 */
inline fun worldMapView(configuration: (@LayoutDslMarker WorldMapView).() -> Unit): WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(WorldMapView(), configuration = configuration)
}

/**
 * Add a [WorldMapView] with configuration block to this manager.
 */
inline fun NodeManager.worldMapView(configuration: (@LayoutDslMarker WorldMapView).() -> Unit):
        WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(WorldMapView(), configuration = configuration))
}

/**
 * Create a styled [WorldMapView].
 */
fun styledWorldMapView(vararg styleClass: String, id: String? = null): WorldMapView =
        styledWorldMapView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [WorldMapView] to this manager.
 */
fun NodeManager.styledWorldMapView(vararg styleClass: String, id: String? = null): WorldMapView =
        styledWorldMapView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [WorldMapView] with configuration block.
 */
inline fun styledWorldMapView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(WorldMapView(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [WorldMapView] with configuration block to this manager.
 */
inline fun NodeManager.styledWorldMapView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker WorldMapView).() -> Unit
): WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(WorldMapView(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.WorldMapView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [WorldMapView] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.worldMapView(): WorldMapView = worldMapView() { }

/**
 * Create a [WorldMapView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun worldMapView(configuration: (@KtfxLayoutDslMarker WorldMapView).() -> Unit):
    WorldMapView {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = WorldMapView()
        child.configuration()
        return child
    }

/**
 * Add a [WorldMapView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.worldMapView(
    configuration: (@KtfxLayoutDslMarker WorldMapView).() ->
    Unit
): WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = WorldMapView()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [WorldMapView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledWorldMapView(vararg styleClass: String, id: String? = null): WorldMapView =
    styledWorldMapView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [WorldMapView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledWorldMapView(vararg styleClass: String, id: String? = null):
    WorldMapView = styledWorldMapView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [WorldMapView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledWorldMapView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker WorldMapView).() -> Unit
): WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = WorldMapView()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [WorldMapView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledWorldMapView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker WorldMapView).() -> Unit
): WorldMapView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = WorldMapView()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

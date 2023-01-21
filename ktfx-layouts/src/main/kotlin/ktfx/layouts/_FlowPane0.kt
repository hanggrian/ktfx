@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.layout.FlowPane
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [FlowPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
): FlowPane = flowPane(orientation = orientation, hgap = hgap, vgap = vgap) { }

/**
 * Create a [FlowPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, hgap, vgap)
    child.configuration()
    return child
}

/**
 * Add a [FlowPane] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, hgap, vgap)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [FlowPane].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
): FlowPane = styledFlowPane(orientation = orientation, hgap = hgap, vgap = vgap, styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [FlowPane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
): FlowPane = styledFlowPane(orientation = orientation, hgap = hgap, vgap = vgap, styleClass =
        *styleClass, id = id) { }

/**
 * Create a styled [FlowPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, hgap, vgap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [FlowPane] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, hgap, vgap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

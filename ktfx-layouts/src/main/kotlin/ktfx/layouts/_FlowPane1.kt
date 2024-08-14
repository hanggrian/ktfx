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
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [FlowPane] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.flowPane(orientation: Orientation = HORIZONTAL, gap: Double = 0.0):
        FlowPane = flowPane(orientation = orientation, gap = gap) { }

/**
 * Create a [FlowPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun flowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
    child.configuration()
    return child
}

/**
 * Add a [FlowPane] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.flowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
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
public inline fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): FlowPane = styledFlowPane(orientation = orientation, gap = gap, styleClass = styleClass, id = id)
        { }

/**
 * Add a styled [FlowPane] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): FlowPane = styledFlowPane(orientation = orientation, gap = gap, styleClass = styleClass, id = id)
        { }

/**
 * Create a styled [FlowPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [FlowPane] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxFlowPane).() -> Unit,
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.layout.FlowPane
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [FlowPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.flowPane(orientation: Orientation = HORIZONTAL, gap: Double = 0.0): FlowPane =
    flowPane(orientation = orientation, gap = gap) { }

/**
 * Create a [FlowPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
    child.configuration()
    return child
}

/**
 * Add a [FlowPane] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
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
fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): FlowPane = styledFlowPane(
    orientation = orientation, gap = gap, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [FlowPane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): FlowPane = styledFlowPane(
    orientation = orientation, gap = gap, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [FlowPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
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
inline fun NodeManager.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    gap: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxFlowPane(orientation, gap)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

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
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [FlowPane] to this manager.
 */
fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double
): FlowPane = flowPane(orientation = orientation, hgap = hgap, vgap = vgap) { }

/**
 * Create a [FlowPane] with configuration block.
 */
inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxFlowPane(orientation, hgap, vgap), configuration = configuration)
}

/**
 * Add a [FlowPane] with configuration block to this manager.
 */
inline fun NodeManager.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxFlowPane(orientation, hgap, vgap), configuration = configuration))
}

/**
 * Create a styled [FlowPane].
 */
fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null
): FlowPane = styledFlowPane(orientation = orientation, hgap = hgap, vgap = vgap, styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [FlowPane] to this manager.
 */
fun NodeManager.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null
): FlowPane = styledFlowPane(orientation = orientation, hgap = hgap, vgap = vgap, styleClass =
        *styleClass, id = id) { }

/**
 * Create a styled [FlowPane] with configuration block.
 */
inline fun styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxFlowPane(orientation, hgap, vgap), styleClass = *styleClass, id = id,
            configuration = configuration)
}

/**
 * Add a styled [FlowPane] with configuration block to this manager.
 */
inline fun NodeManager.styledFlowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double,
    vgap: Double,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxFlowPane).() -> Unit
): FlowPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxFlowPane(orientation, hgap, vgap), styleClass = *styleClass, id =
            id, configuration = configuration))
}

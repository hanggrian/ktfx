@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Arc
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [Arc] to this manager.
 */
fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0
): Arc = arc(
    centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY,
    startAngle =
        startAngle,
    length = length
) { }

/**
 * Create an [Arc] with configuration block.
 */
inline fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    configuration: (@LayoutDslMarker Arc).() -> Unit
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Arc(centerX, centerY, radiusX, radiusY, startAngle, length),
        configuration =
            configuration
    )
}

/**
 * Add an [Arc] with configuration block to this manager.
 */
inline fun NodeManager.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    configuration: (@LayoutDslMarker Arc).() -> Unit
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Arc(centerX, centerY, radiusX, radiusY, startAngle, length),
            configuration = configuration
        )
    )
}

/**
 * Create a styled [Arc].
 */
fun styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Arc = styledArc(
    centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY,
    startAngle = startAngle, length = length, styleClass = *styleClass, id = id
) { }

/**
 * Add a styled [Arc] to this manager.
 */
fun NodeManager.styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Arc = styledArc(
    centerX = centerX, centerY = centerY, radiusX = radiusX, radiusY = radiusY,
    startAngle = startAngle, length = length, styleClass = *styleClass, id = id
) { }

/**
 * Create a styled [Arc] with configuration block.
 */
inline fun styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Arc).() -> Unit
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Arc(centerX, centerY, radiusX, radiusY, startAngle, length),
        styleClass =
            *styleClass,
        id = id, configuration = configuration
    )
}

/**
 * Add a styled [Arc] with configuration block to this manager.
 */
inline fun NodeManager.styledArc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Arc).() -> Unit
): Arc {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Arc(centerX, centerY, radiusX, radiusY, startAngle, length),
            styleClass =
                *styleClass,
            id = id, configuration = configuration
        )
    )
}

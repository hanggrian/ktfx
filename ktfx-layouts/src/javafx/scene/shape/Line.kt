@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Line
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Line] with configuration block. */
inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@LayoutDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Line(centerX, centerY, endX, endY).apply(configuration)
}

/** Add a [Line] to this manager. */
fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = addChild(Line(centerX, centerY, endX, endY))

/** Add a [Line] with configuration block to this manager. */
inline fun NodeManager.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    configuration: (@LayoutDslMarker Line).() -> Unit
): Line {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Line(centerX, centerY, endX, endY), configuration)
}

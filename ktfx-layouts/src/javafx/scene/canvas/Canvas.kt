@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.canvas.Canvas
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Canvas] with configuration block. */
inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Canvas(width, height).apply(configuration)
}

/** Add a [Canvas] to this manager. */
fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0
): Canvas = addChild(Canvas(width, height))

/** Add a [Canvas] with configuration block to this manager. */
inline fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Canvas(width, height), configuration)
}

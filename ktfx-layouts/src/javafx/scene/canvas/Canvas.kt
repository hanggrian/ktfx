@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.canvas.Canvas
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Canvas] with initialization block. */
inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@KtfxLayoutsDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Canvas(width, height).apply(init)
}

/** Add a [Canvas] to this manager. */
fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0
): Canvas = addNode(Canvas(width, height))

/** Add a [Canvas] with initialization block to this manager. */
inline fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@KtfxLayoutsDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Canvas(width, height), init)
}

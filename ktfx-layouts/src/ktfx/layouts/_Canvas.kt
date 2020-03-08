@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.canvas.Canvas
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
 * Add a [Canvas] to this manager.
 */
fun NodeManager.canvas(width: Double = 0.0, height: Double = 0.0): Canvas = canvas(width = width,
        height = height) { }

/**
 * Create a [Canvas] with configuration block.
 */
inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Canvas(width, height), configuration = configuration)
}

/**
 * Add a [Canvas] with configuration block to this manager.
 */
inline fun NodeManager.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Canvas(width, height), configuration = configuration))
}

/**
 * Create a styled [Canvas].
 */
fun styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Canvas = styledCanvas(width = width, height = height, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Canvas] to this manager.
 */
fun NodeManager.styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Canvas = styledCanvas(width = width, height = height, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Canvas] with configuration block.
 */
inline fun styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Canvas(width, height), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [Canvas] with configuration block to this manager.
 */
inline fun NodeManager.styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Canvas).() -> Unit
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Canvas(width, height), styleClass = *styleClass, id = id, configuration =
            configuration))
}

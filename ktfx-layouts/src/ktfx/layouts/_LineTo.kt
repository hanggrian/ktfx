@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.LineTo
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [LineTo] to this manager.
 *
 * @return the control added.
 */
fun PathElementManager.lineTo(x: Double = 0.0, y: Double = 0.0): LineTo = lineTo(x = x, y = y) { }

/**
 * Create a [LineTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker LineTo).() -> Unit
): LineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(LineTo(x, y), configuration = configuration)
}

/**
 * Add a [LineTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun PathElementManager.lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker LineTo).() -> Unit
): LineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(LineTo(x, y), configuration = configuration))
}

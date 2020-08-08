@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.MoveTo
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MoveTo] to this manager.
 *
 * @return the control added.
 */
fun PathElementManager.moveTo(x: Double = 0.0, y: Double = 0.0): MoveTo = moveTo(x = x, y = y) { }

/**
 * Create a [MoveTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker MoveTo).() -> Unit
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MoveTo(x, y), configuration = configuration)
}

/**
 * Add a [MoveTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker MoveTo).() -> Unit
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MoveTo(x, y), configuration = configuration))
}

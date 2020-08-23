@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.MoveTo
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
    configuration: (@KtfxLayoutDslMarker MoveTo).() -> Unit
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MoveTo(x, y)
    child.configuration()
    return child
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
    configuration: (@KtfxLayoutDslMarker MoveTo).() -> Unit
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MoveTo(x, y)
    child.configuration()
    return addChild(child)
}

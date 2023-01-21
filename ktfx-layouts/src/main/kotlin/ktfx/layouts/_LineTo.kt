@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.LineTo
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [LineTo] to this manager.
 *
 * @return the control added.
 */
public fun PathElementManager.lineTo(x: Double = 0.0, y: Double = 0.0): LineTo = lineTo(x = x, y =
        y) { }

/**
 * Create a [LineTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker LineTo).() -> Unit,
): LineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = LineTo(x, y)
    child.configuration()
    return child
}

/**
 * Add a [LineTo] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun PathElementManager.lineTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker LineTo).() -> Unit,
): LineTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = LineTo(x, y)
    child.configuration()
    return addChild(child)
}

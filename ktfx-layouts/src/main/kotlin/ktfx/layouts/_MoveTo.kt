@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.MoveTo
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
 * Add a [MoveTo] to this container.
 *
 * @return the control added.
 */
public fun PathElementContainer.moveTo(x: Double = 0.0, y: Double = 0.0): MoveTo = moveTo(x = x, y =
        y) { }

/**
 * Create a [MoveTo] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker MoveTo).() -> Unit,
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MoveTo(x, y)
    child.configuration()
    return child
}

/**
 * Add a [MoveTo] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun PathElementContainer.moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker MoveTo).() -> Unit,
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MoveTo(x, y)
    child.configuration()
    return addChild(child)
}

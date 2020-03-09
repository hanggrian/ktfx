@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
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
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MoveTo] to this manager.
 */
fun PathElementManager.moveTo(x: Double = 0.0, y: Double = 0.0): MoveTo = moveTo(x = x, y = y) { }

/**
 * Create a [MoveTo] with configuration block.
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
 */
inline fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    configuration: (@LayoutDslMarker MoveTo).() -> Unit
): MoveTo {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MoveTo(x, y), configuration = configuration))
}

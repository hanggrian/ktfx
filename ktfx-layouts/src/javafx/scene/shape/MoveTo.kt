@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.MoveTo
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MoveTo] with initialization block. */
inline fun moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: MoveTo.() -> Unit
): MoveTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return MoveTo(x, y).apply(init)
}

/** Add a [MoveTo] to this manager. */
fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0
): MoveTo = addElement(MoveTo(x, y))

/** Add a [MoveTo] with initialization block to this manager. */
inline fun PathElementManager.moveTo(
    x: Double = 0.0,
    y: Double = 0.0,
    init: MoveTo.() -> Unit
): MoveTo {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addElement(MoveTo(x, y), init)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polygon
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Polygon] with initialization block. */
inline fun polygon(
    vararg points: Double,
    init: Polygon.() -> Unit
): Polygon {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Polygon(*points).apply(init)
}

/** Add a [Polygon] to this manager. */
fun NodeManager.polygon(
    vararg points: Double
): Polygon = addNode(Polygon(*points))

/** Add a [Polygon] with initialization block to this manager. */
inline fun NodeManager.polygon(
    vararg points: Double,
    init: Polygon.() -> Unit
): Polygon {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Polygon(*points), init)
}

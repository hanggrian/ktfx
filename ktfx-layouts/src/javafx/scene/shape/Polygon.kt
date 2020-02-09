@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polygon
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Polygon] with configurationialization block. */
inline fun polygon(
    vararg points: Double,
    configuration: (@LayoutDslMarker Polygon).() -> Unit
): Polygon {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Polygon(*points).apply(configuration)
}

/** Add a [Polygon] to this manager. */
fun NodeManager.polygon(
    vararg points: Double
): Polygon = addChild(Polygon(*points))

/** Add a [Polygon] with configurationialization block to this manager. */
inline fun NodeManager.polygon(
    vararg points: Double,
    configuration: (@LayoutDslMarker Polygon).() -> Unit
): Polygon {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Polygon(*points), configuration)
}

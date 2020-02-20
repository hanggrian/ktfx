@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polyline
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Polyline] with configuration block. */
inline fun polyline(
    vararg points: Double,
    configuration: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Polyline(*points).apply(configuration)
}

/** Add a [Polyline] to this manager. */
fun NodeManager.polyline(
    vararg points: Double
): Polyline = addChild(Polyline(*points))

/** Add a [Polyline] with configuration block to this manager. */
inline fun NodeManager.polyline(
    vararg points: Double,
    configuration: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Polyline(*points), configuration)
}

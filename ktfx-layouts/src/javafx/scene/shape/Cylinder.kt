@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Cylinder
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Cylinder] with initialization block. */
inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutsDslMarker Cylinder).() -> Unit
): Cylinder {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Cylinder(radius, height, division).apply(init)
}

/** Add a [Cylinder] to this manager. */
fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64
): Cylinder = addChild(Cylinder(radius, height, division))

/** Add a [Cylinder] with initialization block to this manager. */
inline fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutsDslMarker Cylinder).() -> Unit
): Cylinder {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(Cylinder(radius, height, division), init)
}

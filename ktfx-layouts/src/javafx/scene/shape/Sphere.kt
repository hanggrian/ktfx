@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Sphere
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Sphere] with initialization block. */
inline fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutsDslMarker Sphere).() -> Unit
): Sphere {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Sphere(radius, division).apply(init)
}

/** Add a [Sphere] to this manager. */
fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64
): Sphere = addNode(Sphere(radius, division))

/** Add a [Sphere] with initialization block to this manager. */
inline fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutsDslMarker Sphere).() -> Unit
): Sphere {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Sphere(radius, division), init)
}

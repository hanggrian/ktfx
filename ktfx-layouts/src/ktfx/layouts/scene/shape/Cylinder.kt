@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Cylinder

/** Creates a [Cylinder]. */
fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: ((@LayoutDslMarker Cylinder).() -> Unit)? = null
): Cylinder = Cylinder(radius, height, division).also { init?.invoke(it) }

/** Creates a [Cylinder] and add it to this manager. */
inline fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDslMarker Cylinder).() -> Unit)? = null
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
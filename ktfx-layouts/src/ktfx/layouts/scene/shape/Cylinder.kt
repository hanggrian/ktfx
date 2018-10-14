@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.shape.Cylinder
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Cylinder]. */
fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = Cylinder(radius, height, division).also { init?.invoke(it) }

/** Creates a [Cylinder] and add it to this manager. */
inline fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.shape.Sphere
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Sphere]. */
fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = Sphere(radius, division).also { init?.invoke(it) }

/** Creates a [Sphere] and add it to this manager. */
inline fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = ktfx.layouts.sphere(radius, division, init)()
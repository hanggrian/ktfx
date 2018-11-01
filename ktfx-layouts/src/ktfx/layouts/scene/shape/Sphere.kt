@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Sphere
import ktfx.NodeManager
import ktfx.LayoutDsl

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
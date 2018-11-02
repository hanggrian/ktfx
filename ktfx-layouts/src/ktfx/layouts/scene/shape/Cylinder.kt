@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Cylinder
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [Cylinder]. */
fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = Cylinder(radius, height, division).also { init?.invoke(it) }

/** Creates a [Cylinder] and add it to this manager. */
inline fun NodeInvokable.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init)()
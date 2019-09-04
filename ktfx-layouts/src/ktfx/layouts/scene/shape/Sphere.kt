@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Sphere

/** Add a [Sphere] to this manager. */
fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64
): Sphere = sphere(radius, division).add()

/** Add a [Sphere] with initialization block to this manager. */
inline fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutDslMarker Sphere).() -> Unit
): Sphere = sphere(radius, division).apply(init)

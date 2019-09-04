@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Cylinder

/** Add a [Cylinder] to this manager. */
fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64
): Cylinder = Cylinder(radius, height, division).add()

/** Add a [Cylinder] with initialization block to this manager. */
inline fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder = cylinder(radius, height, division).apply(init)

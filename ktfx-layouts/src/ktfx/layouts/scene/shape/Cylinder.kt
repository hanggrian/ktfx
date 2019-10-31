@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Cylinder

/** Create a [Cylinder] with initialization block. */
inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder = Cylinder(radius, height, division).apply(init)

/** Add a [Cylinder] to this manager. */
fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64
): Cylinder = addNode(Cylinder(radius, height, division))

/** Add a [Cylinder] with initialization block to this manager. */
inline fun NodeManager.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutDslMarker Cylinder).() -> Unit
): Cylinder = addNode(Cylinder(radius, height, division), init)

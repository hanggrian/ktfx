@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Sphere

/** Create a [Sphere] with initialization block. */
inline fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutDslMarker Sphere).() -> Unit
): Sphere = Sphere(radius, division).apply(init)

/** Add a [Sphere] to this manager. */
fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64
): Sphere = addNode(Sphere(radius, division))

/** Add a [Sphere] with initialization block to this manager. */
inline fun NodeManager.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutDslMarker Sphere).() -> Unit
): Sphere = addNode(Sphere(radius, division), init)

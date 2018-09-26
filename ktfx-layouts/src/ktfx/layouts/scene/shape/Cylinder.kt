@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Cylinder

/** Creates a [Cylinder]. */
fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = Cylinder(radius, height, division).also {
    init?.invoke(it)
}

/** Creates a [Cylinder] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init)()

/** Create a styled [Cylinder]. */
fun styledCylinder(
    styleClass: String,
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = Cylinder(radius, height, division).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Cylinder] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledCylinder(
    styleClass: String,
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = ktfx.layouts.styledCylinder(styleClass, radius, height, division, init)()
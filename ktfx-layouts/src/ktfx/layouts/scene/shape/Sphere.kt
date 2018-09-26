@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.Sphere

/** Creates a [Sphere]. */
fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = Sphere(radius, division).also {
    init?.invoke(it)
}

/** Creates a [Sphere] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = ktfx.layouts.sphere(radius, division, init)()

/** Create a styled [Sphere]. */
fun styledSphere(
    styleClass: String,
    radius: Double = 1.0,
    division: Int = 64,
    init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = Sphere(radius, division).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Sphere] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSphere(
    styleClass: String,
    radius: Double = 1.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = ktfx.layouts.styledSphere(styleClass, radius, division, init)()
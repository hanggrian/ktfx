@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

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
): Sphere = javafxx.layouts.sphere(radius, division, init)()

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
): Sphere = javafxx.layouts.styledSphere(styleClass, radius, division, init)()
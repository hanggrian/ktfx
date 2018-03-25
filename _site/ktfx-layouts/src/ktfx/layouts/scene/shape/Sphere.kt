@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Sphere

inline fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = Sphere(radius, division).also { init?.invoke(it) }

inline fun LayoutManager<Node>.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Sphere).() -> Unit)? = null
): Sphere = ktfx.layouts.sphere(radius, division, init).add()
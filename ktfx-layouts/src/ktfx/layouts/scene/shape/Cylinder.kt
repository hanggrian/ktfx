@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Cylinder

inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = Cylinder(radius, height, division).also { init?.invoke(it) }

inline fun LayoutManager<Node>.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
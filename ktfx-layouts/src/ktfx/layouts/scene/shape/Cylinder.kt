@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Cylinder

inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64
): Cylinder = cylinder(radius, height, division) { }

inline fun cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutDsl Cylinder).() -> Unit
): Cylinder = Cylinder(radius, height, division).apply(init)

inline fun LayoutManager<Node>.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64
): Cylinder = cylinder(radius, height, division) { }

inline fun LayoutManager<Node>.cylinder(
    radius: Double = 1.0,
    height: Double = 2.0,
    division: Int = 64,
    init: (@LayoutDsl Cylinder).() -> Unit
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
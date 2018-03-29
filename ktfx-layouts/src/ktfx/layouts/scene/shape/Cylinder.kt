@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Cylinder

inline fun cylinder(
    radius: Number = 1,
    height: Number = 2,
    division: Int = 64
): Cylinder = cylinder(radius, height, division) { }

fun cylinder(
    radius: Number = 1,
    height: Number = 2,
    division: Int = 64,
    init: (@LayoutDsl Cylinder).() -> Unit
): Cylinder = Cylinder(radius.toDouble(), height.toDouble(), division).apply(init)

inline fun LayoutManager<Node>.cylinder(
    radius: Number = 1,
    height: Number = 2,
    division: Int = 64
): Cylinder = cylinder(radius, height, division) { }

inline fun LayoutManager<Node>.cylinder(
    radius: Number = 1,
    height: Number = 2,
    division: Int = 64,
    noinline init: (@LayoutDsl Cylinder).() -> Unit
): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Sphere

inline fun sphere(
    radius: Number = 1,
    division: Int = 64
): Sphere = sphere(radius, division) { }

fun sphere(
    radius: Number = 1,
    division: Int = 64,
    init: (@LayoutDsl Sphere).() -> Unit
): Sphere = Sphere(radius.toDouble(), division).apply(init)

inline fun LayoutManager<Node>.sphere(
    radius: Number = 1,
    division: Int = 64
): Sphere = sphere(radius, division) { }

inline fun LayoutManager<Node>.sphere(
    radius: Number = 1,
    division: Int = 64,
    noinline init: (@LayoutDsl Sphere).() -> Unit
): Sphere = ktfx.layouts.sphere(radius, division, init).add()
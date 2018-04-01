@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Sphere

inline fun sphere(
    radius: Double = 1.0,
    division: Int = 64
): Sphere = sphere(radius, division) { }

inline fun sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutDsl Sphere).() -> Unit
): Sphere = Sphere(radius, division).apply(init)

inline fun LayoutManager<Node>.sphere(
    radius: Double = 1.0,
    division: Int = 64
): Sphere = sphere(radius, division) { }

inline fun LayoutManager<Node>.sphere(
    radius: Double = 1.0,
    division: Int = 64,
    init: (@LayoutDsl Sphere).() -> Unit
): Sphere = ktfx.layouts.sphere(radius, division, init).add()
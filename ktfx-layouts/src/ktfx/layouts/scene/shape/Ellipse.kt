@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Ellipse

inline fun ellipse(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0
): Ellipse = ellipse(centerX, centerY, radiusX, radiusY) { }

fun ellipse(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0,
    init: (@LayoutDsl Ellipse).() -> Unit
): Ellipse = Ellipse(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble()).apply(init)

inline fun LayoutManager<Node>.ellipse(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0
): Ellipse = ellipse(centerX, centerY, radiusX, radiusY) { }

inline fun LayoutManager<Node>.ellipse(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0,
    noinline init: (@LayoutDsl Ellipse).() -> Unit
): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init).add()
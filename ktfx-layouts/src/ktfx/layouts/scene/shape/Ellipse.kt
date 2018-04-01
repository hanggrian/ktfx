@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Ellipse

inline fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0
): Ellipse = ellipse(centerX, centerY, radiusX, radiusY) { }

inline fun ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: (@LayoutDsl Ellipse).() -> Unit
): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply(init)

inline fun LayoutManager<Node>.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0
): Ellipse = ellipse(centerX, centerY, radiusX, radiusY) { }

inline fun LayoutManager<Node>.ellipse(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    init: (@LayoutDsl Ellipse).() -> Unit
): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Arc

inline fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0
): Arc = arc(centerX, centerY, radiusX, radiusY, startAngle, length) { }

inline fun arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutDsl Arc).() -> Unit
): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply(init)

inline fun LayoutManager<Node>.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0
): Arc = arc(centerX, centerY, radiusX, radiusY, startAngle, length) { }

inline fun LayoutManager<Node>.arc(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radiusX: Double = 0.0,
    radiusY: Double = 0.0,
    startAngle: Double = 0.0,
    length: Double = 0.0,
    init: (@LayoutDsl Arc).() -> Unit
): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init).add()
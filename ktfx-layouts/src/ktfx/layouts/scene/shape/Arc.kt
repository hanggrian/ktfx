@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Arc

inline fun arc(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0,
    startAngle: Number = 0,
    length: Number = 0
): Arc = arc(centerX, centerY, radiusX, radiusY, startAngle, length) { }

fun arc(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0,
    startAngle: Number = 0,
    length: Number = 0,
    init: (@LayoutDsl Arc).() -> Unit
): Arc = Arc(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble(), startAngle.toDouble(),
    length.toDouble()).apply(init)

inline fun LayoutManager<Node>.arc(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0,
    startAngle: Number = 0,
    length: Number = 0
): Arc = arc(centerX, centerY, radiusX, radiusY, startAngle, length) { }

inline fun LayoutManager<Node>.arc(
    centerX: Number = 0,
    centerY: Number = 0,
    radiusX: Number = 0,
    radiusY: Number = 0,
    startAngle: Number = 0,
    length: Number = 0,
    noinline init: (@LayoutDsl Arc).() -> Unit
): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.CubicCurve

inline fun cubicCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX1: Number = 0,
    controlY1: Number = 0,
    controlX2: Number = 0,
    controlY2: Number = 0,
    endX: Number = 0,
    endY: Number = 0
): CubicCurve = cubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY) { }

fun cubicCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX1: Number = 0,
    controlY1: Number = 0,
    controlX2: Number = 0,
    controlY2: Number = 0,
    endX: Number = 0,
    endY: Number = 0,
    init: (@LayoutDsl CubicCurve).() -> Unit
): CubicCurve = CubicCurve(startX.toDouble(), startY.toDouble(), controlX1.toDouble(), controlY1.toDouble(),
    controlX2.toDouble(), controlY2.toDouble(), endX.toDouble(), endY.toDouble()).apply(init)

inline fun LayoutManager<Node>.cubicCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX1: Number = 0,
    controlY1: Number = 0,
    controlX2: Number = 0,
    controlY2: Number = 0,
    endX: Number = 0,
    endY: Number = 0
): CubicCurve = cubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY) { }
    .add()

inline fun LayoutManager<Node>.cubicCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX1: Number = 0,
    controlY1: Number = 0,
    controlX2: Number = 0,
    controlY2: Number = 0,
    endX: Number = 0,
    endY: Number = 0,
    noinline init: (@LayoutDsl CubicCurve).() -> Unit
): CubicCurve = ktfx.layouts.cubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY, init)
    .add()
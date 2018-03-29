@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.QuadCurve

inline fun quadCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX: Number = 0,
    controlY: Number = 0,
    endX: Number = 0,
    endY: Number = 0
): QuadCurve = quadCurve(startX, startY, controlX, controlY, endX, endY) { }

fun quadCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX: Number = 0,
    controlY: Number = 0,
    endX: Number = 0,
    endY: Number = 0,
    init: (@LayoutDsl QuadCurve).() -> Unit
): QuadCurve = QuadCurve(startX.toDouble(), startY.toDouble(), controlX.toDouble(), controlY.toDouble(),
    endX.toDouble(), endY.toDouble()).apply(init)

inline fun LayoutManager<Node>.quadCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX: Number = 0,
    controlY: Number = 0,
    endX: Number = 0,
    endY: Number = 0
): QuadCurve = quadCurve(startX, startY, controlX, controlY, endX, endY) { }

inline fun LayoutManager<Node>.quadCurve(
    startX: Number = 0,
    startY: Number = 0,
    controlX: Number = 0,
    controlY: Number = 0,
    endX: Number = 0,
    endY: Number = 0,
    noinline init: (@LayoutDsl QuadCurve).() -> Unit
): QuadCurve = ktfx.layouts.quadCurve(startX, startY, controlX, controlY, endX, endY, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.QuadCurve

inline fun quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): QuadCurve = quadCurve(startX, startY, controlX, controlY, endX, endY) { }

inline fun quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDsl QuadCurve).() -> Unit
): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply(init)

inline fun LayoutManager<Node>.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): QuadCurve = quadCurve(startX, startY, controlX, controlY, endX, endY) { }

inline fun LayoutManager<Node>.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDsl QuadCurve).() -> Unit
): QuadCurve = ktfx.layouts.quadCurve(startX, startY, controlX, controlY, endX, endY, init).add()
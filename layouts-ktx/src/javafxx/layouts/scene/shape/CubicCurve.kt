@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.shape.CubicCurve

/** Creates a [CubicCurve]. */
fun cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl CubicCurve).() -> Unit)? = null
): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).also {
    init?.invoke(it)
}

/** Creates a [CubicCurve] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.cubicCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl CubicCurve).() -> Unit)? = null
): CubicCurve = javafxx.layouts.cubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY, init)()

/** Create a styled [CubicCurve]. */
fun styledCubicCurve(
    styleClass: String,
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl CubicCurve).() -> Unit)? = null
): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [CubicCurve] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledCubicCurve(
    styleClass: String,
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX1: Double = 0.0,
    controlY1: Double = 0.0,
    controlX2: Double = 0.0,
    controlY2: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl CubicCurve).() -> Unit)? = null
): CubicCurve = javafxx.layouts.styledCubicCurve(styleClass, startX, startY, controlX1, controlY1, controlX2, controlY2,
    endX, endY, init)()
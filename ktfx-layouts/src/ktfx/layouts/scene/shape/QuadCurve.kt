@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.QuadCurve

/** Creates a [QuadCurve]. */
fun quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl QuadCurve).() -> Unit)? = null
): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).also {
    init?.invoke(it)
}

/** Creates a [QuadCurve] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.quadCurve(
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl QuadCurve).() -> Unit)? = null
): QuadCurve = ktfx.layouts.quadCurve(startX, startY, controlX, controlY, endX, endY, init)()

/** Create a styled [QuadCurve]. */
fun styledQuadCurve(
    styleClass: String,
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl QuadCurve).() -> Unit)? = null
): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [QuadCurve] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledQuadCurve(
    styleClass: String,
    startX: Double = 0.0,
    startY: Double = 0.0,
    controlX: Double = 0.0,
    controlY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl QuadCurve).() -> Unit)? = null
): QuadCurve = ktfx.layouts.styledQuadCurve(styleClass, startX, startY, controlX, controlY, endX, endY, init)()
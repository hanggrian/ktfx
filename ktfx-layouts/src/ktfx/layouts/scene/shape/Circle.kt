@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

inline fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null
): Circle = circle(centerX, centerY, radius, fill) { }

inline fun circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: (@LayoutDsl Circle).() -> Unit
): Circle = Circle(centerX, centerY, radius, fill).apply(init)

inline fun LayoutManager<Node>.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null
): Circle = circle(centerX, centerY, radius, fill) { }

inline fun LayoutManager<Node>.circle(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    radius: Double = 0.0,
    fill: Paint? = null,
    init: (@LayoutDsl Circle).() -> Unit
): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init).add()
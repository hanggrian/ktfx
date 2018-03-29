@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

inline fun circle(
    centerX: Number = 0,
    centerY: Number = 0,
    radius: Number = 0,
    fill: Paint? = null
): Circle = circle(centerX, centerY, radius, fill) { }

fun circle(
    centerX: Number = 0,
    centerY: Number = 0,
    radius: Number = 0,
    fill: Paint? = null,
    init: (@LayoutDsl Circle).() -> Unit
): Circle = Circle(centerX.toDouble(), centerY.toDouble(), radius.toDouble(), fill).apply(init)

inline fun LayoutManager<Node>.circle(
    centerX: Number = 0,
    centerY: Number = 0,
    radius: Number = 0,
    fill: Paint? = null
): Circle = circle(centerX, centerY, radius, fill) { }

inline fun LayoutManager<Node>.circle(
    centerX: Number = 0,
    centerY: Number = 0,
    radius: Number = 0,
    fill: Paint? = null,
    noinline init: (@LayoutDsl Circle).() -> Unit
): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Line

inline fun line(
    centerX: Number = 0,
    centerY: Number = 0,
    endX: Number = 0,
    endY: Number = 0
): Line = line(centerX, centerY, endX, endY) { }

fun line(
    centerX: Number = 0,
    centerY: Number = 0,
    endX: Number = 0,
    endY: Number = 0,
    init: (@LayoutDsl Line).() -> Unit
): Line = Line(centerX.toDouble(), centerY.toDouble(), endX.toDouble(), endY.toDouble()).apply(init)

inline fun LayoutManager<Node>.line(
    centerX: Number = 0,
    centerY: Number = 0,
    endX: Number = 0,
    endY: Number = 0
): Line = line(centerX, centerY, endX, endY) { }

inline fun LayoutManager<Node>.line(
    centerX: Number = 0,
    centerY: Number = 0,
    endX: Number = 0,
    endY: Number = 0,
    noinline init: (@LayoutDsl Line).() -> Unit
): Line = ktfx.layouts.line(centerX, centerY, endX, endY, init).add()
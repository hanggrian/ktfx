@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Line

inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = line(centerX, centerY, endX, endY) { }

inline fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDsl Line).() -> Unit
): Line = Line(centerX, centerY, endX, endY).apply(init)

inline fun LayoutManager<Node>.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0
): Line = line(centerX, centerY, endX, endY) { }

inline fun LayoutManager<Node>.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: (@LayoutDsl Line).() -> Unit
): Line = ktfx.layouts.line(centerX, centerY, endX, endY, init).add()
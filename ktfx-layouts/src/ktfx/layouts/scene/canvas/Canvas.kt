@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.canvas.Canvas

inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0
): Canvas = canvas(width, height) { }

inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDsl Canvas).() -> Unit
): Canvas = Canvas(width, height).apply(init)

inline fun LayoutManager<Node>.canvas(
    width: Double = 0.0,
    height: Double = 0.0
): Canvas = canvas(width, height) { }

inline fun LayoutManager<Node>.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: (@LayoutDsl Canvas).() -> Unit
): Canvas = ktfx.layouts.canvas(width, height, init).add()
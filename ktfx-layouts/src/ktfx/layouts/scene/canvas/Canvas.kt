@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.canvas.Canvas

inline fun canvas(
    width: Number = 0,
    height: Number = 0
): Canvas = canvas(width, height) { }

fun canvas(
    width: Number = 0,
    height: Number = 0,
    init: (@LayoutDsl Canvas).() -> Unit
): Canvas = Canvas(width.toDouble(), height.toDouble()).apply(init)

inline fun LayoutManager<Node>.canvas(
    width: Number = 0,
    height: Number = 0
): Canvas = canvas(width, height) { }

inline fun LayoutManager<Node>.canvas(
    width: Number = 0,
    height: Number = 0,
    noinline init: (@LayoutDsl Canvas).() -> Unit
): Canvas = ktfx.layouts.canvas(width, height, init).add()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Rectangle

inline fun rectangle(
    x: Number = 0,
    y: Number = 0,
    width: Number = 0,
    height: Number = 0
): Rectangle = rectangle(x, y, width, height) { }

fun rectangle(
    x: Number = 0,
    y: Number = 0,
    width: Number = 0,
    height: Number = 0,
    init: (@LayoutDsl Rectangle).() -> Unit
): Rectangle = Rectangle(x.toDouble(), y.toDouble(), width.toDouble(), height.toDouble()).apply(init)

inline fun LayoutManager<Node>.rectangle(
    x: Number = 0,
    y: Number = 0,
    width: Number = 0,
    height: Number = 0
): Rectangle = rectangle(x, y, width, height) { }

inline fun LayoutManager<Node>.rectangle(
    x: Number = 0,
    y: Number = 0,
    width: Number = 0,
    height: Number = 0,
    noinline init: (@LayoutDsl Rectangle).() -> Unit
): Rectangle = ktfx.layouts.rectangle(x, y, width, height, init).add()
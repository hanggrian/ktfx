@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

inline fun box(
    width: Number = DEFAULT_SIZE,
    height: Number = DEFAULT_SIZE,
    depth: Number = DEFAULT_SIZE
): Box = box(width, height, depth) { }

fun box(
    width: Number = DEFAULT_SIZE,
    height: Number = DEFAULT_SIZE,
    depth: Number = DEFAULT_SIZE,
    init: (@LayoutDsl Box).() -> Unit
): Box = Box(width.toDouble(), height.toDouble(), depth.toDouble()).apply(init)

inline fun LayoutManager<Node>.box(
    width: Number = DEFAULT_SIZE,
    height: Number = DEFAULT_SIZE,
    depth: Number = DEFAULT_SIZE
): Box = box(width, height, depth) { }

inline fun LayoutManager<Node>.box(
    width: Number = DEFAULT_SIZE,
    height: Number = DEFAULT_SIZE,
    depth: Number = DEFAULT_SIZE,
    noinline init: (@LayoutDsl Box).() -> Unit
): Box = ktfx.layouts.box(width, height, depth, init).add()
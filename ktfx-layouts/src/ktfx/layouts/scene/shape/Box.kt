@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

inline fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE
): Box = box(width, height, depth) { }

inline fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: (@LayoutDsl Box).() -> Unit
): Box = Box(width, height, depth).apply(init)

inline fun LayoutManager<Node>.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE
): Box = box(width, height, depth) { }

inline fun LayoutManager<Node>.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    init: (@LayoutDsl Box).() -> Unit
): Box = ktfx.layouts.box(width, height, depth, init).add()
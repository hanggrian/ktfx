@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE

inline fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    noinline init: ((@LayoutDsl Box).() -> Unit)? = null
): Box = Box(width, height, depth).also { init?.invoke(it) }

inline fun LayoutManager<Node>.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    noinline init: ((@LayoutDsl Box).() -> Unit)? = null
): Box = ktfx.layouts.box(width, height, depth, init).add()
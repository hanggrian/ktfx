@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Rectangle

inline fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Rectangle).() -> Unit)? = null
): Rectangle = Rectangle(x, y, width, height).also { init?.invoke(it) }

inline fun LayoutManager<Node>.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Rectangle).() -> Unit)? = null
): Rectangle = ktfx.layouts.rectangle(x, y, width, height, init).add()
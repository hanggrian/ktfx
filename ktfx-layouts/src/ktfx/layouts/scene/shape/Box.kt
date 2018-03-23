@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Box

inline fun box(width: Double = Box.DEFAULT_SIZE, height: Double = Box.DEFAULT_SIZE, depth: Double = Box.DEFAULT_SIZE, noinline init: ((@LayoutDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }
inline fun ChildManager.box(width: Double = Box.DEFAULT_SIZE, height: Double = Box.DEFAULT_SIZE, depth: Double = Box.DEFAULT_SIZE, noinline init: ((@LayoutDsl Box).() -> Unit)? = null): Box = ktfx.layouts.box(width, height, depth, init).add()
inline fun ItemManager.box(width: Double = Box.DEFAULT_SIZE, height: Double = Box.DEFAULT_SIZE, depth: Double = Box.DEFAULT_SIZE, noinline init: ((@LayoutDsl Box).() -> Unit)? = null): Box = ktfx.layouts.box(width, height, depth, init).add()
inline fun ButtonManager.box(width: Double = Box.DEFAULT_SIZE, height: Double = Box.DEFAULT_SIZE, depth: Double = Box.DEFAULT_SIZE, noinline init: ((@LayoutDsl Box).() -> Unit)? = null): Box = ktfx.layouts.box(width, height, depth, init).add()
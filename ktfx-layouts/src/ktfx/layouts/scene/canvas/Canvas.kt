@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.canvas.Canvas

inline fun canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width, height).apply { init?.invoke(this) }
inline fun ChildManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = ktfx.layouts.canvas(width, height, init).add()
inline fun ItemManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = ktfx.layouts.canvas(width, height, init).add()
inline fun ButtonManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = ktfx.layouts.canvas(width, height, init).add()
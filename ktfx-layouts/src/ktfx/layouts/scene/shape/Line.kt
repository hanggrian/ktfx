@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Line

inline fun line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@LayoutDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@LayoutDsl Line).() -> Unit)? = null): Line = ktfx.layouts.line(centerX, centerY, endX, endY, init).add()
inline fun ItemManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@LayoutDsl Line).() -> Unit)? = null): Line = ktfx.layouts.line(centerX, centerY, endX, endY, init).add()
inline fun ButtonManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@LayoutDsl Line).() -> Unit)? = null): Line = ktfx.layouts.line(centerX, centerY, endX, endY, init).add()
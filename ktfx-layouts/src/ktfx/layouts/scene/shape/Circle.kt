@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.paint.Paint
import javafx.scene.shape.Circle

inline fun circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@LayoutDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }
inline fun ChildManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@LayoutDsl Circle).() -> Unit)? = null): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init).add()
inline fun ItemManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@LayoutDsl Circle).() -> Unit)? = null): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init).add()
inline fun ButtonManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@LayoutDsl Circle).() -> Unit)? = null): Circle = ktfx.layouts.circle(centerX, centerY, radius, fill, init).add()
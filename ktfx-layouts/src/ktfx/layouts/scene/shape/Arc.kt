@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Arc

inline fun arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@LayoutDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }
inline fun ChildManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@LayoutDsl Arc).() -> Unit)? = null): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init).add()
inline fun ItemManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@LayoutDsl Arc).() -> Unit)? = null): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init).add()
inline fun ButtonManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@LayoutDsl Arc).() -> Unit)? = null): Arc = ktfx.layouts.arc(centerX, centerY, radiusX, radiusY, startAngle, length, init).add()
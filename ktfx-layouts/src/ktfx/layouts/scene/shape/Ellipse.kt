@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Ellipse

inline fun ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@LayoutDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }
inline fun ChildManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@LayoutDsl Ellipse).() -> Unit)? = null): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init).add()
inline fun ItemManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@LayoutDsl Ellipse).() -> Unit)? = null): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init).add()
inline fun ButtonManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@LayoutDsl Ellipse).() -> Unit)? = null): Ellipse = ktfx.layouts.ellipse(centerX, centerY, radiusX, radiusY, init).add()
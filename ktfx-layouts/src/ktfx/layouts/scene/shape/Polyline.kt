@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Polyline

inline fun polyline(vararg points: Double, noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }
inline fun ChildManager.polyline(vararg points: Double, noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null): Polyline = ktfx.layouts.polyline(*points, init = init).add()
inline fun ItemManager.polyline(vararg points: Double, noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null): Polyline = ktfx.layouts.polyline(*points, init = init).add()
inline fun ButtonManager.polyline(vararg points: Double, noinline init: ((@LayoutDsl Polyline).() -> Unit)? = null): Polyline = ktfx.layouts.polyline(*points, init = init).add()
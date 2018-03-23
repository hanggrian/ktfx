@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Cylinder

inline fun cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }
inline fun ChildManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
inline fun ItemManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
inline fun ButtonManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@LayoutDsl Cylinder).() -> Unit)? = null): Cylinder = ktfx.layouts.cylinder(radius, height, division, init).add()
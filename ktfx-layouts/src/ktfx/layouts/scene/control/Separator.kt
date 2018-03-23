@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.control.Separator

inline fun separator(orientation: Orientation = Orientation.HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }
inline fun ChildManager.separator(orientation: Orientation = Orientation.HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()
inline fun ItemManager.separator(orientation: Orientation = Orientation.HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()
inline fun ButtonManager.separator(orientation: Orientation = Orientation.HORIZONTAL, noinline init: ((@LayoutDsl Separator).() -> Unit)? = null): Separator = ktfx.layouts.separator(orientation, init).add()
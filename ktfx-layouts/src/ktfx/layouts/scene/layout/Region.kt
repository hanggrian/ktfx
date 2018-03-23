@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.layout.Region

inline fun region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = Region().apply { init?.invoke(this) }
inline fun ChildManager.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()
inline fun ItemManager.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()
inline fun ButtonManager.region(noinline init: ((@LayoutDsl Region).() -> Unit)? = null): Region = ktfx.layouts.region(init).add()
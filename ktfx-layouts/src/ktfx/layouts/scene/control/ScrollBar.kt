@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ScrollBar

inline fun scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }
inline fun ChildManager.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()
inline fun ItemManager.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()
inline fun ButtonManager.scrollBar(noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null): ScrollBar = ktfx.layouts.scrollBar(init).add()
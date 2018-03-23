@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.layout.Pane

inline fun pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = Pane().apply { init?.invoke(this) }
inline fun ChildManager.pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = ktfx.layouts.pane(init).add()
inline fun ItemManager.pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = ktfx.layouts.pane(init).add()
inline fun ButtonManager.pane(noinline init: ((@LayoutDsl Pane).() -> Unit)? = null): Pane = ktfx.layouts.pane(init).add()
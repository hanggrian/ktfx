@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

inline fun separatorMenuItem(noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }

inline fun Manager<MenuItem>.separatorMenuItem(noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = ktfx.layouts.separatorMenuItem(init).add()
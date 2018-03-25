@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

inline fun separatorMenuItem(
    noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().also { init?.invoke(it) }

inline fun LayoutManager<MenuItem>.separatorMenuItem(
    noinline init: ((@LayoutDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = ktfx.layouts.separatorMenuItem(init).add()
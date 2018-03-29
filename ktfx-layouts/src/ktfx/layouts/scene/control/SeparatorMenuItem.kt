@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.MenuItem
import javafx.scene.control.SeparatorMenuItem

inline fun separatorMenuItem(): SeparatorMenuItem = separatorMenuItem { }

inline fun separatorMenuItem(
    init: (@LayoutDsl SeparatorMenuItem).() -> Unit
): SeparatorMenuItem = SeparatorMenuItem().apply(init)

inline fun LayoutManager<MenuItem>.separatorMenuItem(): SeparatorMenuItem = separatorMenuItem { }

inline fun LayoutManager<MenuItem>.separatorMenuItem(
    init: (@LayoutDsl SeparatorMenuItem).() -> Unit
): SeparatorMenuItem = ktfx.layouts.separatorMenuItem(init).add()
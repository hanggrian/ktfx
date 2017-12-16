@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.menus

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import kotfx.internal.LayoutDsl
import kotfx.internal.PopupManager

class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupManager

inline fun contextMenuOf(
        vararg items: MenuItem,
        noinline init: (@LayoutDsl _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu(*items).apply(init)
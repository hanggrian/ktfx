@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.control.ContextMenu
import javafx.scene.control.Control
import javafx.scene.control.MenuItem
import kotfx.internal.LayoutDsl

class _ContextMenu(vararg items: MenuItem) : ContextMenu(*items), PopupManager

inline fun contextMenu(
        vararg items: MenuItem,
        noinline init: (@LayoutDsl _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu(*items).apply(init)

inline fun Control.contextMenu(
        vararg items: MenuItem,
        noinline init: (@LayoutDsl _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu(*items).apply {
    init()
    contextMenu = this
}
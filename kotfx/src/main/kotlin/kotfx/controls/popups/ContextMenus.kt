@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import kotfx.controls._ContextMenu
import kotfx.internal.LayoutDsl

inline fun contextMenuOf(
        vararg items: MenuItem,
        noinline init: (@LayoutDsl _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu(*items).apply(init)
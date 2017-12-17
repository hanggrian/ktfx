@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import kotfx.controls._ContextMenu
import kotfx.internal.KotfxDsl

inline fun contextMenu(
        vararg items: MenuItem,
        noinline init: (@KotfxDsl _ContextMenu).() -> Unit
): ContextMenu = _ContextMenu(*items).apply(init)
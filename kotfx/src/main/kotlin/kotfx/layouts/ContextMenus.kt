@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import kotfx.internal.ControlDsl

class _ContextMenu : ContextMenu(), PopupManager

@JvmOverloads
inline fun contextMenu(
        vararg items: MenuItem,
        noinline init: ((@ControlDsl ContextMenu).() -> Unit)? = null
): ContextMenu = ContextMenu(*items).apply { init?.invoke(this) }
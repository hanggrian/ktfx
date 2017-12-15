@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.control.ContextMenu
import javafx.scene.control.MenuItem
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun contextMenu(
        vararg items: MenuItem,
        noinline init: ((@ControlDsl ContextMenu).() -> Unit)? = null
): ContextMenu = ContextMenu(*items).apply { init?.invoke(this) }
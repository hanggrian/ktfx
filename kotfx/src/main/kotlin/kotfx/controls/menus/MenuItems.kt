@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.menus

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotfx.internal.ControlDsl
import kotfx.internal.PopupManager

@JvmOverloads
inline fun menuItemOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.menuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl MenuItem).() -> Unit)? = null
): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()
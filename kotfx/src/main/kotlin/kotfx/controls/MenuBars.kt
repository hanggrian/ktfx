@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager
import kotfx.internal.MenuManager

class _MenuBar(vararg menus: Menu) : MenuBar(*menus), MenuManager

@JvmOverloads
inline fun menuBarOf(
        vararg menus: Menu,
        noinline init: ((@ControlDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.menuBar(
        vararg menus: Menu,
        noinline init: ((@ControlDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.menuBar(
        vararg menus: Menu,
        noinline init: ((@ControlDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()
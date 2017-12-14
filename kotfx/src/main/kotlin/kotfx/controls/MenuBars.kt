@file:JvmMultifileClass
@file:JvmName("MenusKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun menuBar(
        vararg menus: Menu,
        noinline init: ((@ControlDsl MenuBar).() -> Unit)? = null
): MenuBar = MenuBar(*menus).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.menuBar(
        vararg menus: Menu,
        noinline init: ((@ControlDsl MenuBar).() -> Unit)? = null
): MenuBar = MenuBar(*menus).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import kotfx.controls.ItemManager
import kotfx.controls._MenuBar
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun menuBar(
        vararg menus: Menu,
        noinline init: ((@KotfxDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.menuBar(
        vararg menus: Menu,
        noinline init: ((@KotfxDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.menuBar(
        vararg menus: Menu,
        noinline init: ((@KotfxDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()
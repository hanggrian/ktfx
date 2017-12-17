@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun splitMenuButton(
        vararg items: MenuItem,
        noinline init: ((@KotfxDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.splitMenuButton(
        vararg items: MenuItem,
        noinline init: ((@KotfxDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.splitMenuButton(
        vararg items: MenuItem,
        noinline init: ((@KotfxDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()
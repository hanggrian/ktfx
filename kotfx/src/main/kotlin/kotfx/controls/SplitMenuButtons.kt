@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun splitMenuButton(
        vararg items: MenuItem,
        noinline init: ((@ControlDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.splitMenuButton(
        vararg items: MenuItem,
        noinline init: ((@ControlDsl SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.SeparatorMenuItem
import kotfx.internal.KotfxDsl
import kotfx.internal.PopupManager

@JvmOverloads
inline fun separatorMenuItem(
        noinline init: ((@KotfxDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.separatorMenuItem(
        noinline init: ((@KotfxDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()
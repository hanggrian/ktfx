@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.control.SeparatorMenuItem
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun separatorMenuItem(
        noinline init: ((@ControlDsl SeparatorMenuItem).() -> Unit)? = null
): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
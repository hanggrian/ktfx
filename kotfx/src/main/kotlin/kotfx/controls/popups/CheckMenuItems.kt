@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import kotfx.internal.ControlDsl
import kotfx.internal.PopupManager

@JvmOverloads
inline fun checkMenuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.checkMenuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }.add()
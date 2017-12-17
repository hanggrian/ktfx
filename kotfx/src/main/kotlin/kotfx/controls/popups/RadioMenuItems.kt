@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.RadioMenuItem
import kotfx.internal.KotfxDsl
import kotfx.internal.PopupManager

@JvmOverloads
inline fun radioMenuItemOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.radioMenuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@KotfxDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()
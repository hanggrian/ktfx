@file:JvmMultifileClass
@file:JvmName("PopupsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls.popups

import javafx.scene.Node
import javafx.scene.control.RadioMenuItem
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun radioMenuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun PopupManager.radioMenuItem(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()
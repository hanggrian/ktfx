@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun toggleButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.toggleButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()
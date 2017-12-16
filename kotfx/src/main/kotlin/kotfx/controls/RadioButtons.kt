@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.RadioButton
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun radioButton(
        text: String? = null,
        noinline init: ((@ControlDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.radioButton(
        text: String? = null,
        noinline init: ((@ControlDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()
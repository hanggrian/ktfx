@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.TextArea
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun textArea(
        noinline init: ((@ControlDsl TextArea).() -> Unit)? = null
): TextArea = TextArea().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.textArea(
        noinline init: ((@ControlDsl TextArea).() -> Unit)? = null
): TextArea = TextArea().apply { init?.invoke(this) }.add()
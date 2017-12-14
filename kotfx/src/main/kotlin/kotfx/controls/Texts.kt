@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.text.Text
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun text(
        text: String? = null,
        noinline init: ((@ControlDsl Text).() -> Unit)? = null
): Text = Text(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.text(
        text: String? = null,
        noinline init: ((@ControlDsl Text).() -> Unit)? = null
): Text = Text(text).apply { init?.invoke(this) }.add()
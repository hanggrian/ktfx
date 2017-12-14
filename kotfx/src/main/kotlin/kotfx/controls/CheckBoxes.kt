@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.CheckBox
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun checkBox(
        text: String? = null,
        noinline init: ((@ControlDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.checkBox(
        text: String? = null,
        noinline init: ((@ControlDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()
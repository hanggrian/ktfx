@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.TextField
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun textFieldOf(
        text: String = "",
        noinline init: ((@ControlDsl TextField).() -> Unit)? = null
): TextField = TextField(text).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.textField(
        text: String = "",
        noinline init: ((@ControlDsl TextField).() -> Unit)? = null
): TextField = TextField(text).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.textField(
        text: String = "",
        noinline init: ((@ControlDsl TextField).() -> Unit)? = null
): TextField = TextField(text).apply { init?.invoke(this) }.add()
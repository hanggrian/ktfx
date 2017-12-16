@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.ButtonBar
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun buttonBarOf(
        buttonOrder: String? = null,
        noinline init: ((@ControlDsl ButtonBar).() -> Unit)? = null
): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.buttonBar(
        buttonOrder: String? = null,
        noinline init: ((@ControlDsl ButtonBar).() -> Unit)? = null
): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.buttonBar(
        buttonOrder: String? = null,
        noinline init: ((@ControlDsl ButtonBar).() -> Unit)? = null
): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.Label
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun labelOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Label).() -> Unit)? = null
): Label = Label(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Label).() -> Unit)? = null
): Label = Label(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.label(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Label).() -> Unit)? = null
): Label = Label(text, graphic).apply { init?.invoke(this) }.add()
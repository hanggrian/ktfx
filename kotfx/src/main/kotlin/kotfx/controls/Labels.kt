@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Label
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun label(
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
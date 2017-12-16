@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Button
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).apply { init?.invoke(this) }.add()
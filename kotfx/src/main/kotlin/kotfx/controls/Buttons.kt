@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Button
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _Button(text: String?, graphic: Node?) : Button(text, graphic), _Labeled<Button> {
    override val node: Button get() = this

    fun default(value: Boolean) = setDefaultButton(value)
    fun cancel(value: Boolean) = setCancelButton(value)
}

@JvmOverloads
inline fun buttonOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _Button).() -> Unit)? = null
): Button = _Button(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _Button).() -> Unit)? = null
): Button = buttonOf(text, graphic, init).add()
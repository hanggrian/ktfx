@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.Button
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _Button(text: String?, graphic: Node?) : Button(text, graphic), _Labeled<Button> {

    override val instance: Button get() = this

}

@JvmOverloads
inline fun button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _Button).() -> Unit)? = null
): Button = _Button(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.button(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _Button).() -> Unit)? = null
): Button = _Button(text, graphic).apply { if (init != null) init() }.add()
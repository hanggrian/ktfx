@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _ToggleButton(text: String?, graphic: Node?) : ToggleButton(text, graphic), _Labeled<ToggleButton>, _Toggled<ToggleButton> {
    override val node: ToggleButton get() = this
}

@JvmOverloads
inline fun toggleButtonOf(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _ToggleButton).() -> Unit)? = null
): ToggleButton = _ToggleButton(text, graphic).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.toggleButton(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl _ToggleButton).() -> Unit)? = null
): ToggleButton = toggleButtonOf(text, graphic, init).add()
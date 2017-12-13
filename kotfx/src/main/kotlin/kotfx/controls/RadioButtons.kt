@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.RadioButton
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _RadioButton(text: String?) : RadioButton(text), _Labeled<RadioButton>, _Toggled<RadioButton> {
    override val node: RadioButton get() = this
}

@JvmOverloads
inline fun radioButtonOf(
        text: String? = null,
        noinline init: ((@ControlDsl _RadioButton).() -> Unit)? = null
): RadioButton = _RadioButton(text).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.radioButton(
        text: String? = null,
        noinline init: ((@ControlDsl _RadioButton).() -> Unit)? = null
): RadioButton = radioButtonOf(text, init).add()
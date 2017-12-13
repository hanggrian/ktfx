@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.CheckBox
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _CheckBox(text: String?) : CheckBox(text), _Labeled<CheckBox> {
    override val node: CheckBox get() = this

    fun indeterminate(value: Boolean) = setIndeterminate(value)
    fun selected(value: Boolean) = setSelected(value)
    fun allowIndeterminate(value: Boolean) = setAllowIndeterminate(value)
}

@JvmOverloads
inline fun checkBoxOf(
        text: String? = null,
        noinline init: ((@ControlDsl _CheckBox).() -> Unit)? = null
): CheckBox = _CheckBox(text).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.checkBox(
        text: String? = null,
        noinline init: ((@ControlDsl _CheckBox).() -> Unit)? = null
): CheckBox = checkBoxOf(text, init).add()
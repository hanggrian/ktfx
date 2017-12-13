@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.CheckBox
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _CheckBox(text: String?) : CheckBox(text), _Labeled<CheckBox> {
    override val control: CheckBox get() = this
    fun indeterminate(indeterminate: Boolean) = control.setIndeterminate(indeterminate)
    fun selected(selected: Boolean) = control.setSelected(selected)
    fun allowIndeterminate(indeterminate: Boolean) = control.setAllowIndeterminate(indeterminate)
}

@JvmOverloads
inline fun checkBox(
        text: String? = null,
        noinline init: ((@ControlDsl _CheckBox).() -> Unit)? = null
): CheckBox = _CheckBox(text).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.checkBox(
        text: String? = null,
        noinline init: ((@ControlDsl _CheckBox).() -> Unit)? = null
): CheckBox = _CheckBox(text).apply { if (init != null) init() }.add()
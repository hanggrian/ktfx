@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.TextField
import kotfx._Pane
import kotfx.internal.ControlDsl

class _TextField(text: String?) : TextField(text), _TextInputControl<TextField> {
    override val node: TextField get() = this
}

@JvmOverloads
inline fun textFieldOf(
        text: String? = null,
        noinline init: ((@ControlDsl _TextField).() -> Unit)? = null
): TextField = _TextField(text).apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.textField(
        text: String? = null,
        noinline init: ((@ControlDsl _TextField).() -> Unit)? = null
): TextField = _TextField(text).apply { if (init != null) init() }.add()
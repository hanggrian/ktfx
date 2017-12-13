@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.PasswordField
import kotfx.ChildManager
import kotfx.internal.ControlDsl

class _PasswordField : PasswordField(), _TextInputControl<PasswordField> {
    override val node: PasswordField get() = this
}

@JvmOverloads
inline fun passwordFieldOf(
        noinline init: ((@ControlDsl _PasswordField).() -> Unit)? = null
): PasswordField = _PasswordField().apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.passwordField(
        noinline init: ((@ControlDsl _PasswordField).() -> Unit)? = null
): PasswordField = passwordFieldOf(init).add()
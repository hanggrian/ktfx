@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.PasswordField
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun passwordField(
        noinline init: ((@ControlDsl PasswordField).() -> Unit)? = null
): PasswordField = PasswordField().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.passwordField(
        noinline init: ((@ControlDsl PasswordField).() -> Unit)? = null
): PasswordField = PasswordField().apply { init?.invoke(this) }.add()
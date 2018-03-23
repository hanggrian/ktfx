@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.PasswordField

inline fun passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }
inline fun ChildManager.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()
inline fun ItemManager.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()
inline fun ButtonManager.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()
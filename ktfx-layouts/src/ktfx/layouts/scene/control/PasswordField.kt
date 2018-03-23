@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.PasswordField

inline fun passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }

inline fun Manager<Node>.passwordField(noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null): PasswordField = ktfx.layouts.passwordField(init).add()
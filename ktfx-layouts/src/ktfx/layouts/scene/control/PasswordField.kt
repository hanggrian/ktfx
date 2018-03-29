@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.PasswordField

inline fun passwordField(): PasswordField = passwordField { }

inline fun passwordField(
    init: (@LayoutDsl PasswordField).() -> Unit
): PasswordField = PasswordField().apply(init)

inline fun LayoutManager<Node>.passwordField(): PasswordField = passwordField { }

inline fun LayoutManager<Node>.passwordField(
    init: (@LayoutDsl PasswordField).() -> Unit
): PasswordField = ktfx.layouts.passwordField(init).add()
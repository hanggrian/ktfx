@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.PasswordField

/** Add a [PasswordField] to this manager. */
fun NodeManager.passwordField(): PasswordField =
    PasswordField().add()

/** Add a [PasswordField] with initialization block to this manager. */
inline fun NodeManager.passwordField(
    init: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField = passwordField().apply(init)

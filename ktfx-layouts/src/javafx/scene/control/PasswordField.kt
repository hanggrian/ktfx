@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.PasswordField

/** Create a [PasswordField] with initialization block. */
inline fun passwordField(
    init: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField = PasswordField().apply(init)

/** Add a [PasswordField] to this manager. */
fun NodeManager.passwordField(): PasswordField =
    addNode(PasswordField())

/** Add a [PasswordField] with initialization block to this manager. */
inline fun NodeManager.passwordField(
    init: (@LayoutDslMarker PasswordField).() -> Unit
): PasswordField = addNode(PasswordField(), init)

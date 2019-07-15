@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.PasswordField

/** Creates a [PasswordField]. */
fun passwordField(
    init: ((@LayoutDslMarker PasswordField).() -> Unit)? = null
): PasswordField = PasswordField().also { init?.invoke(it) }

/** Creates a [PasswordField] and add it to this manager. */
inline fun NodeManager.passwordField(
    noinline init: ((@LayoutDslMarker PasswordField).() -> Unit)? = null
): PasswordField = ktfx.layouts.passwordField(init).add()

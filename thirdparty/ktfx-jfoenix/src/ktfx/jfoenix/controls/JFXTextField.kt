@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTextField
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXTextField]. */
fun jfxTextField(
    text: String? = null,
    init: ((@LayoutDsl JFXTextField).() -> Unit)? = null
): JFXTextField = JFXTextField(text.orEmpty()).also { init?.invoke(it) }

/** Creates a [JFXTextField] and add it to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXTextField).() -> Unit)? = null
): JFXTextField = ktfx.jfoenix.jfxTextField(text, init)()
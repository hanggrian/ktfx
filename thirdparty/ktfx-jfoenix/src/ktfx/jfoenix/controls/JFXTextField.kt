@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTextField
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXTextField]. */
fun jfxTextField(
    init: ((@LayoutDsl JFXTextField).() -> Unit)? = null
): JFXTextField = JFXTextField().also {
    init?.invoke(it)
}

/** Creates a [JFXTextField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxPasswordField(
    noinline init: ((@LayoutDsl JFXTextField).() -> Unit)? = null
): JFXTextField = ktfx.jfoenix.jfxTextField(init)()
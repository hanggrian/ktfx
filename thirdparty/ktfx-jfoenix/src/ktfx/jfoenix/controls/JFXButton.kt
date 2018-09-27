@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXButton
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXButton]. */
fun jfxButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl JFXButton).() -> Unit)? = null
): JFXButton = JFXButton(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [JFXButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl JFXButton).() -> Unit)? = null
): JFXButton = ktfx.jfoenix.jfxButton(text, graphic, init)()
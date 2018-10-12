@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXRadioButton
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXRadioButton]. */
fun jfxRadioButton(
    text: String? = null,
    init: ((@LayoutDsl JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = JFXRadioButton(text).also { init?.invoke(it) }

/** Creates a [JFXRadioButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxRadioButton(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXRadioButton).() -> Unit)? = null
): JFXRadioButton = ktfx.jfoenix.jfxRadioButton(text, init)()
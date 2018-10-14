@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [Hyperlink]. */
fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).also { init?.invoke(it) }

/** Creates a [Hyperlink] and add it to this manager. */
inline fun NodeManager.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink

/** Creates a [Hyperlink]. */
fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).also { init?.invoke(it) }

/** Creates a [Hyperlink] and add it to this manager. */
inline fun NodeInvokable.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label

/** Creates a [Label]. */
fun label(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Label).() -> Unit)? = null
): Label = Label(text, graphic).also { init?.invoke(it) }

/** Creates a [Label] and add it to this manager. */
inline fun NodeInvokable.label(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Label).() -> Unit)? = null
): Label = ktfx.layouts.label(text, graphic, init)()
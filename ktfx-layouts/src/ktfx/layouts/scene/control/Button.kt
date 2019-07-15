@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

/** Creates a [Button]. */
fun button(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDslMarker Button).() -> Unit)? = null
): Button = Button(text, graphic).also { init?.invoke(it) }

/** Creates a [Button] and add it to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker Button).() -> Unit)? = null
): Button = ktfx.layouts.button(text, graphic, init).add()

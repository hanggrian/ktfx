@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

/** Creates a [Button]. */
fun button(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDslMarker Button).() -> Unit)? = null
): Button = Button(text, graphic).also { init?.invoke(it) }

/** Creates a [Button] with initialization block. */
fun button(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDslMarker Button).() -> Unit)? = null
): Button = Button(text, graphic).also { init?.invoke(it) }

/** Creates and add a [Button] to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker Button).() -> Unit)? = null
): Button = ktfx.layouts.button(text, graphic, init).add()

/** Creates and add a [Button] with initialization block to this manager. */
inline fun NodeManager.button(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDslMarker Button).() -> Unit)? = null
): Button = ktfx.layouts.button(text, graphic, init).add()
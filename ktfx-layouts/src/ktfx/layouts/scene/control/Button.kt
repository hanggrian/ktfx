@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [Button]. */
fun button(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).also { init?.invoke(it) }

/** Creates a [Button] and add it to this manager. */
inline fun NodeInvokable.button(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = ktfx.layouts.button(text, graphic, init)()
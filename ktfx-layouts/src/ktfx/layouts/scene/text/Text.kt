@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.text.Text
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [Text]. */
fun text(
    text: String? = null,
    init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = Text(text).also { init?.invoke(it) }

/** Creates a [Text] and add it to this manager. */
inline fun NodeManager.text(
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = ktfx.layouts.text(text, init)()
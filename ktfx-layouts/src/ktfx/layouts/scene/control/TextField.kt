@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TextField
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [TextField]. */
fun textField(
    text: String = "",
    init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = TextField(text).also { init?.invoke(it) }

/** Creates a [TextField] and add it to this manager. */
inline fun NodeManager.textField(
    text: String = "",
    noinline init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = ktfx.layouts.textField(text, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TextField

/** Creates a [TextField]. */
fun textField(
    text: String = "",
    init: ((@LayoutMarker TextField).() -> Unit)? = null
): TextField = TextField(text).also { init?.invoke(it) }

/** Creates a [TextField] and add it to this manager. */
inline fun NodeInvokable.textField(
    text: String = "",
    noinline init: ((@LayoutMarker TextField).() -> Unit)? = null
): TextField = ktfx.layouts.textField(text, init)()
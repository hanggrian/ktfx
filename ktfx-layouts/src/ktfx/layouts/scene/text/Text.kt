@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.text.Text

/** Creates a [Text]. */
fun text(
    text: String? = null,
    init: ((@LayoutMarker Text).() -> Unit)? = null
): Text = Text(text).also { init?.invoke(it) }

/** Creates a [Text] and add it to this manager. */
inline fun NodeInvokable.text(
    text: String? = null,
    noinline init: ((@LayoutMarker Text).() -> Unit)? = null
): Text = ktfx.layouts.text(text, init)()
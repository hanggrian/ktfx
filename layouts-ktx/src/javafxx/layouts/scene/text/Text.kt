@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.text.Text

/** Creates a [Text]. */
fun text(
    text: String? = null,
    init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = Text(text).also {
    init?.invoke(it)
}

/** Creates a [Text] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.text(
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = javafxx.layouts.text(text, init)()

/** Create a styled [Text]. */
fun styledText(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = Text(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Text] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledText(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = javafxx.layouts.styledText(styleClass, text, init)()
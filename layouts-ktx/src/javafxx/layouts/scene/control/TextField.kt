@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TextField

/** Creates a [TextField]. */
fun textField(
    text: String = "",
    init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = TextField(text).also {
    init?.invoke(it)
}

/** Creates a [TextField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.textField(
    text: String = "",
    noinline init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = javafxx.layouts.textField(text, init)()

/** Create a styled [TextField]. */
fun styledTextField(
    styleClass: String,
    text: String = "",
    init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = TextField(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TextField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledTextField(
    styleClass: String,
    text: String = "",
    noinline init: ((@LayoutDsl TextField).() -> Unit)? = null
): TextField = javafxx.layouts.styledTextField(styleClass, text, init)()
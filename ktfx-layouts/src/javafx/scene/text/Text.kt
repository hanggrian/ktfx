@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.text.Text

/** Create a [Text] with initialization block. */
inline fun text(
    text: String? = null,
    init: (@LayoutDslMarker Text).() -> Unit
): Text = Text(text).apply(init)

/** Add a [Text] to this manager. */
fun NodeManager.text(
    text: String? = null
): Text = addNode(Text(text))

/** Add a [Text] with initialization block to this manager. */
inline fun NodeManager.text(
    text: String? = null,
    init: (@LayoutDslMarker Text).() -> Unit
): Text = addNode(Text(text), init)

@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TextField

/** Create a [TextField] with initialization block. */
inline fun textField(
    text: String = "",
    init: (@LayoutDslMarker TextField).() -> Unit
): TextField = TextField(text).apply(init)

/** Add a [TextField] to this manager. */
fun NodeManager.textField(
    text: String = ""
): TextField = addNode(ktfx.layouts.textField(text) { })

/** Add a [TextField] with initialization block to this manager. */
inline fun NodeManager.textField(
    text: String = "",
    init: (@LayoutDslMarker TextField).() -> Unit
): TextField = addNode(ktfx.layouts.textField(text, init))

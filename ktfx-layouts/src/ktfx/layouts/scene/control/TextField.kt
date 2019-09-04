@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TextField

/** Add a [TextField] to this manager. */
fun NodeManager.textField(
    text: String = ""
): TextField = TextField(text).add()

/** Add a [TextField] with initialization block to this manager. */
inline fun NodeManager.textField(
    text: String = "",
    init: (@LayoutDslMarker TextField).() -> Unit
): TextField = textField(text).apply(init)

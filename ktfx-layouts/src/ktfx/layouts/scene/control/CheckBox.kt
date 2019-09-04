@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.CheckBox

/** Add a [CheckBox] to this manager. */
fun NodeManager.checkBox(
    text: String? = null
): CheckBox = CheckBox(text).add()

/** Add a [CheckBox] with initialization block to this manager. */
inline fun NodeManager.checkBox(
    text: String? = null,
    init: (@LayoutDslMarker CheckBox).() -> Unit
): CheckBox = checkBox(text).apply(init)

@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.CheckBox

/** Create a [CheckBox] with initialization block. */
inline fun checkBox(
    text: String? = null,
    init: (@LayoutDslMarker CheckBox).() -> Unit
): CheckBox = CheckBox(text).apply(init)

/** Add a [CheckBox] to this manager. */
fun NodeManager.checkBox(
    text: String? = null
): CheckBox = addNode(ktfx.layouts.checkBox(text) { })

/** Add a [CheckBox] with initialization block to this manager. */
inline fun NodeManager.checkBox(
    text: String? = null,
    init: (@LayoutDslMarker CheckBox).() -> Unit
): CheckBox = addNode(ktfx.layouts.checkBox(text, init))

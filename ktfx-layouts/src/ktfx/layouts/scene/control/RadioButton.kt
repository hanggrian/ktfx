@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.RadioButton

/** Create a [RadioButton] with initialization block. */
inline fun radioButton(
    text: String? = null,
    init: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton = RadioButton(text).apply(init)

/** Add a [RadioButton] to this manager. */
fun NodeManager.radioButton(
    text: String? = null
): RadioButton = addNode(RadioButton(text))

/** Add a [RadioButton] with initialization block to this manager. */
inline fun NodeManager.radioButton(
    text: String? = null,
    init: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton = addNode(RadioButton(text), init)

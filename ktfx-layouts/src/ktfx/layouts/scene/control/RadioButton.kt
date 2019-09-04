@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.RadioButton

/** Add a [RadioButton] to this manager. */
fun NodeManager.radioButton(
    text: String? = null
): RadioButton = RadioButton(text).add()

/** Add a [RadioButton] with initialization block to this manager. */
inline fun NodeManager.radioButton(
    text: String? = null,
    init: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton = radioButton(text).apply(init)

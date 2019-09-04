@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton

/** Add a [ToggleButton] to this manager. */
fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = ToggleButton(text, graphic).add()

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = toggleButton(text, graphic).apply(init)

/** Add a [ToggleButton] to this manager. */
fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = ToggleButton(text, graphic).add()

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = toggleButton(text, graphic).apply(init)

@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton

/** Create a [ToggleButton] with initialization block. */
inline fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = ToggleButton(text, graphic).apply(init)

/** Add a [ToggleButton] to this manager. */
fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addNode(ToggleButton(text, graphic))

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = addNode(ToggleButton(text, graphic), init)

/** Add a [ToggleButton] to this manager. */
fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addButton(ToggleButton(text, graphic))

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = addButton(ToggleButton(text, graphic), init)

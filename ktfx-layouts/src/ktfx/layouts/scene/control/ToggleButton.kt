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
): ToggleButton = addNode(ktfx.layouts.toggleButton(text, graphic) { })

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = addNode(ktfx.layouts.toggleButton(text, graphic, init))

/** Add a [ToggleButton] to this manager. */
fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addButton(ktfx.layouts.toggleButton(text, graphic) { })

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton = addButton(ktfx.layouts.toggleButton(text, graphic, init))

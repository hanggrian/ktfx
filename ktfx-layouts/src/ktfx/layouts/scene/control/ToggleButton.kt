@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [ToggleButton]. */
fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ToggleButton(text, graphic).also { init?.invoke(it) }

/** Creates a [ToggleButton] and add it to this manager. */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl ToggleButton).() -> Unit)? = null
): ToggleButton = ktfx.layouts.toggleButton(text, graphic, init)()
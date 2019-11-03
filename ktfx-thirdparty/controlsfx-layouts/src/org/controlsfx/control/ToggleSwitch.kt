@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.controlsfx.layouts

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.ToggleSwitch

/** Create a [ToggleSwitch] with initialization block. */
inline fun toggleSwitch(
    text: String? = null,
    init: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch = ToggleSwitch(text).apply(init)

/** Add a [ToggleSwitch] to this manager. */
fun NodeManager.toggleSwitch(
    text: String? = null
): ToggleSwitch = addNode(ToggleSwitch(text))

/** Add a [ToggleSwitch] with initialization block to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    init: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch = addNode(ToggleSwitch(text), init)

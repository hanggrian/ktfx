@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ToggleSwitch

/** Add a [ToggleSwitch] to this manager. */
fun NodeManager.toggleSwitch(
    text: String? = null
): ToggleSwitch = ToggleSwitch(text).add()

/** Add a [ToggleSwitch] with initialization block to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    init: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch = toggleSwitch(text).apply(init)

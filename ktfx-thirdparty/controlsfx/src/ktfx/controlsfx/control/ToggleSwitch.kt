@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.ToggleSwitch

/** Create a [ToggleSwitch] with initialization block. */
inline fun toggleSwitch(
    text: String? = null,
    init: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch = ToggleSwitch(text).apply(init)

/** Add a [ToggleSwitch] to this manager. */
fun NodeManager.toggleSwitch(
    text: String? = null
): ToggleSwitch = addNode(ktfx.controlsfx.toggleSwitch(text) { })

/** Add a [ToggleSwitch] with initialization block to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    init: (@LayoutDslMarker ToggleSwitch).() -> Unit
): ToggleSwitch = addNode(ktfx.controlsfx.toggleSwitch(text, init))

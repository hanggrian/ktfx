@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutDslMarker
import org.controlsfx.control.ToggleSwitch

/** Creates a [ToggleSwitch]. */
fun toggleSwitch(
    text: String? = null,
    init: ((@LayoutDslMarker ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ToggleSwitch(text).also { init?.invoke(it) }

/** Creates a [ToggleSwitch] and add it to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    noinline init: ((@LayoutDslMarker ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ktfx.controlsfx.toggleSwitch(text, init).add()
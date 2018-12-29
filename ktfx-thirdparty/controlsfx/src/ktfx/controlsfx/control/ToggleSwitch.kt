@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import ktfx.layouts.NodeInvokable
import ktfx.layouts.LayoutMarker
import org.controlsfx.control.ToggleSwitch

/** Creates a [ToggleSwitch]. */
fun toggleSwitch(
    text: String? = null,
    init: ((@LayoutMarker ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ToggleSwitch(text).also { init?.invoke(it) }

/** Creates a [ToggleSwitch] and add it to this manager. */
inline fun NodeInvokable.toggleSwitch(
    text: String? = null,
    noinline init: ((@LayoutMarker ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ktfx.controlsfx.toggleSwitch(text, init)()
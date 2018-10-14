@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.ToggleSwitch

/** Creates a [ToggleSwitch]. */
fun toggleSwitch(
    text: String? = null,
    init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ToggleSwitch(text).also { init?.invoke(it) }

/** Creates a [ToggleSwitch] and add it to this manager. */
inline fun NodeManager.toggleSwitch(
    text: String? = null,
    noinline init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ktfx.controlsfx.toggleSwitch(text, init)()
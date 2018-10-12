@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.ToggleSwitch

/** Creates a [ToggleSwitch]. */
fun toggleSwitch(
    text: String? = null,
    init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ToggleSwitch(text).also { init?.invoke(it) }

/** Creates a [ToggleSwitch] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.toggleSwitch(
    text: String? = null,
    noinline init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ktfx.controlsfx.toggleSwitch(text, init)()
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.ToggleSwitch

/** Creates a [ToggleSwitch]. */
fun toggleSwitch(
    text: String? = null,
    init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ToggleSwitch(text).also {
    init?.invoke(it)
}

/** Creates a [ToggleSwitch] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.toggleSwitch(
    text: String? = null,
    noinline init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ktfx.controlsfx.toggleSwitch(text, init)()

/** Create a styled [ToggleSwitch]. */
fun styledToggleSwitch(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ToggleSwitch(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ToggleSwitch] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledToggleSwitch(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl ToggleSwitch).() -> Unit)? = null
): ToggleSwitch = ktfx.controlsfx.styledToggleSwitch(styleClass, text, init)()
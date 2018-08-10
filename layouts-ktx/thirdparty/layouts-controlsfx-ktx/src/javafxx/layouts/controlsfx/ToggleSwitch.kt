@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
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
): ToggleSwitch = javafxx.layouts.controlsfx.toggleSwitch(text, init)()

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
): ToggleSwitch = javafxx.layouts.controlsfx.styledToggleSwitch(styleClass, text, init)()
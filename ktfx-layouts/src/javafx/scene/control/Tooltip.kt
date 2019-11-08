@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.Tooltip
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Tooltip] with initialization block. */
inline fun tooltip(
    text: String? = null,
    init: Tooltip.() -> Unit
): Tooltip {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Tooltip(text).apply(init) }

/** Set a [Tooltip] to this [Node]. */
fun Node.tooltip(
    text: String? = null
): Tooltip = Tooltip(text).also { Tooltip.install(this, it) }

/** Set a [Tooltip] with initialization block to this [Node]. */
inline fun Node.tooltip(
    text: String? = null,
    init: Tooltip.() -> Unit
): Tooltip {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.tooltip(text, init).also { Tooltip.install(this, it) } }

/** Set a [Tooltip] to this [Control]. */
fun Control.tooltip(
    text: String? = null
): Tooltip = Tooltip(text).also { tooltip = it }

/** Set a [Tooltip] with initialization block to this [Control]. */
inline fun Control.tooltip(
    text: String? = null,
    init: Tooltip.() -> Unit
): Tooltip {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.tooltip(text, init).also { tooltip = it } }

/** Set a [Tooltip] to this [Tab]. */
fun Tab.tooltip(
    text: String? = null
): Tooltip = Tooltip(text).also { tooltip = it }

/** Set a [Tooltip] with initialization block to this [Tab]. */
inline fun Tab.tooltip(
    text: String? = null,
    init: Tooltip.() -> Unit
): Tooltip {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.tooltip(text, init).also { tooltip = it }
}

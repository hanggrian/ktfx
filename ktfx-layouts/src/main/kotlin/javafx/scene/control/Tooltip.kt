@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Control
import javafx.scene.control.Tab
import javafx.scene.control.Tooltip
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Tooltip] with configuration block. */
public inline fun tooltip(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker Tooltip).() -> Unit,
): Tooltip {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Tooltip(text).apply(configuration)
}

/** Set a [Tooltip] to this [Node]. */
public fun Node.tooltip(text: String? = null): Tooltip =
    Tooltip(text).also { Tooltip.install(this, it) }

/** Set a [Tooltip] with configuration block to this [Node]. */
public inline fun Node.tooltip(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker Tooltip).() -> Unit,
): Tooltip {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.tooltip(text, configuration).also { Tooltip.install(this, it) }
}

/** Set a [Tooltip] to this [Control]. */
public fun Control.tooltip(text: String? = null): Tooltip = Tooltip(text).also { tooltip = it }

/** Set a [Tooltip] with configuration block to this [Control]. */
public inline fun Control.tooltip(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker Tooltip).() -> Unit,
): Tooltip {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.tooltip(text, configuration).also { tooltip = it }
}

/** Set a [Tooltip] to this [Tab]. */
public fun Tab.tooltip(text: String? = null): Tooltip = Tooltip(text).also { tooltip = it }

/** Set a [Tooltip] with configuration block to this [Tab]. */
public inline fun Tab.tooltip(
    text: String? = null,
    configuration: (@KtfxLayoutDslMarker Tooltip).() -> Unit,
): Tooltip {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ktfx.layouts.tooltip(text, configuration).also { tooltip = it }
}

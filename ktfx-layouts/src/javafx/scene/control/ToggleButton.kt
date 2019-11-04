@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ToggleButton] with initialization block. */
inline fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return ToggleButton(text, graphic).apply(init)
}
/** Add a [ToggleButton] to this manager. */
fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addNode(ToggleButton(text, graphic))

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(ToggleButton(text, graphic), init)
}
/** Add a [ToggleButton] to this manager. */
fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addButton(ToggleButton(text, graphic))

/** Add a [ToggleButton] with initialization block to this manager. */
inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addButton(ToggleButton(text, graphic), init)
}

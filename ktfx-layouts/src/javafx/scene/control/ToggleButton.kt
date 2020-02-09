@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ToggleButton] with configurationialization block. */
inline fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ToggleButton(text, graphic).apply(configuration)
}

/** Add a [ToggleButton] to this manager. */
fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addChild(ToggleButton(text, graphic))

/** Add a [ToggleButton] with configurationialization block to this manager. */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ToggleButton(text, graphic), configuration)
}

/** Add a [ToggleButton] to this manager. */
fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null
): ToggleButton = addChild(ToggleButton(text, graphic))

/** Add a [ToggleButton] with configurationialization block to this manager. */
inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ToggleButton(text, graphic), configuration)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ToggleButton] to this manager.
 */
fun NodeManager.toggleButton(text: String, graphic: Node): ToggleButton = toggleButton(text = text,
        graphic = graphic) { }

/**
 * Add a [ToggleButton] to this manager.
 */
fun ToggleButtonManager.toggleButton(text: String, graphic: Node): ToggleButton = toggleButton(text
        = text, graphic = graphic) { }

/**
 * Create a [ToggleButton] with configuration block.
 */
inline fun toggleButton(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ToggleButton(text, graphic), configuration = configuration)
}

/**
 * Add a [ToggleButton] with configuration block to this manager.
 */
inline fun NodeManager.toggleButton(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), configuration = configuration))
}

/**
 * Add a [ToggleButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.toggleButton(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), configuration = configuration))
}

/**
 * Create a styled [ToggleButton].
 */
fun styledToggleButton(
    text: String,
    graphic: Node,
    vararg styleClass: String
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [ToggleButton] to this manager.
 */
fun NodeManager.styledToggleButton(
    text: String,
    graphic: Node,
    vararg styleClass: String
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [ToggleButton] to this manager.
 */
fun ToggleButtonManager.styledToggleButton(
    text: String,
    graphic: Node,
    vararg styleClass: String
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [ToggleButton] with configuration block.
 */
inline fun styledToggleButton(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ToggleButton(text, graphic), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 */
inline fun NodeManager.styledToggleButton(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.styledToggleButton(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

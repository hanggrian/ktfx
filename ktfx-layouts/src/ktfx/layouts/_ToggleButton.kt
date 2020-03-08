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
fun NodeManager.toggleButton(text: String? = null, graphic: Node? = null): ToggleButton =
        toggleButton(text = text, graphic = graphic) { }

/**
 * Add a [ToggleButton] to this manager.
 */
fun ToggleButtonManager.toggleButton(text: String? = null, graphic: Node? = null): ToggleButton =
        toggleButton(text = text, graphic = graphic) { }

/**
 * Create a [ToggleButton] with configuration block.
 */
inline fun toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ToggleButton(text, graphic), configuration = configuration)
}

/**
 * Add a [ToggleButton] with configuration block to this manager.
 */
inline fun NodeManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), configuration = configuration))
}

/**
 * Add a [ToggleButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.toggleButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), configuration = configuration))
}

/**
 * Create a styled [ToggleButton].
 */
fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [ToggleButton] to this manager.
 */
fun NodeManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [ToggleButton] to this manager.
 */
fun ToggleButtonManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(text = text, graphic = graphic, styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [ToggleButton] with configuration block.
 */
inline fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ToggleButton(text, graphic), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 */
inline fun NodeManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration))
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ToggleButton(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration))
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToggleButton
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ToggleButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.toggleButton(text: String? = null, graphic: Node? = null): ToggleButton =
    toggleButton(text = text, graphic = graphic) { }

/**
 * Add a [ToggleButton] to this manager.
 *
 * @return the control added.
 */
fun ToggleButtonManager.toggleButton(text: String? = null, graphic: Node? = null): ToggleButton =
    toggleButton(text = text, graphic = graphic) { }

/**
 * Create a [ToggleButton] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
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
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [ToggleButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [ToggleButton] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun ToggleButtonManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): ToggleButton = styledToggleButton(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [ToggleButton] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ToggleButton(text, graphic), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ToggleButton(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

/**
 * Add a styled [ToggleButton] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun ToggleButtonManager.styledToggleButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ToggleButton).() -> Unit
): ToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ToggleButton(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

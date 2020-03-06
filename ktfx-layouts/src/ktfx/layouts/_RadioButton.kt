@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.RadioButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [RadioButton] to this manager.
 */
fun NodeManager.radioButton(text: String): RadioButton = radioButton(text = text) { }

/**
 * Add a [RadioButton] to this manager.
 */
fun ToggleButtonManager.radioButton(text: String): RadioButton = radioButton(text = text) { }

/**
 * Create a [RadioButton] with configuration block.
 */
inline fun radioButton(text: String, configuration: (@LayoutDslMarker RadioButton).() -> Unit):
        RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(RadioButton(text), configuration = configuration)
}

/**
 * Add a [RadioButton] with configuration block to this manager.
 */
inline fun NodeManager.radioButton(text: String, configuration: (@LayoutDslMarker RadioButton).() ->
        Unit): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioButton(text), configuration = configuration))
}

/**
 * Add a [RadioButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.radioButton(text: String, configuration: (@LayoutDslMarker
        RadioButton).() -> Unit): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioButton(text), configuration = configuration))
}

/**
 * Create a styled [RadioButton].
 */
fun styledRadioButton(text: String, vararg styleClass: String): RadioButton = styledRadioButton(text
        = text, styleClass = *styleClass) { }

/**
 * Add a styled [RadioButton] to this manager.
 */
fun NodeManager.styledRadioButton(text: String, vararg styleClass: String): RadioButton =
        styledRadioButton(text = text, styleClass = *styleClass) { }

/**
 * Add a styled [RadioButton] to this manager.
 */
fun ToggleButtonManager.styledRadioButton(text: String, vararg styleClass: String): RadioButton =
        styledRadioButton(text = text, styleClass = *styleClass) { }

/**
 * Create a styled [RadioButton] with configuration block.
 */
inline fun styledRadioButton(
    text: String,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(RadioButton(text), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [RadioButton] with configuration block to this manager.
 */
inline fun NodeManager.styledRadioButton(
    text: String,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioButton(text), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a styled [RadioButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.styledRadioButton(
    text: String,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioButton(text), styleClass = *styleClass, configuration =
            configuration))
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextField
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [TextField] to this manager.
 */
fun NodeManager.textField(text: String = ""): TextField = textField(text = text) { }

/**
 * Create a [TextField] with configuration block.
 */
inline fun textField(text: String = "", configuration: (@LayoutDslMarker TextField).() -> Unit):
        TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TextField(text), configuration = configuration)
}

/**
 * Add a [TextField] with configuration block to this manager.
 */
inline fun NodeManager.textField(text: String = "", configuration: (@LayoutDslMarker
        TextField).() -> Unit): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TextField(text), configuration = configuration))
}

/**
 * Create a styled [TextField].
 */
fun styledTextField(text: String = "", vararg styleClass: String): TextField = styledTextField(text
        = text, styleClass = *styleClass) { }

/**
 * Add a styled [TextField] to this manager.
 */
fun NodeManager.styledTextField(text: String = "", vararg styleClass: String): TextField =
        styledTextField(text = text, styleClass = *styleClass) { }

/**
 * Create a styled [TextField] with configuration block.
 */
inline fun styledTextField(
    text: String = "",
    vararg styleClass: String,
    configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TextField(text), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [TextField] with configuration block to this manager.
 */
inline fun NodeManager.styledTextField(
    text: String = "",
    vararg styleClass: String,
    configuration: (@LayoutDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TextField(text), styleClass = *styleClass, configuration =
            configuration))
}

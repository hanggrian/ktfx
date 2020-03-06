@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextArea
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [TextArea] to this manager.
 */
fun NodeManager.textArea(text: String = ""): TextArea = textArea(text = text) { }

/**
 * Create a [TextArea] with configuration block.
 */
inline fun textArea(text: String = "", configuration: (@LayoutDslMarker TextArea).() -> Unit):
        TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TextArea(text), configuration = configuration)
}

/**
 * Add a [TextArea] with configuration block to this manager.
 */
inline fun NodeManager.textArea(text: String = "", configuration: (@LayoutDslMarker TextArea).() ->
        Unit): TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TextArea(text), configuration = configuration))
}

/**
 * Create a styled [TextArea].
 */
fun styledTextArea(text: String = "", vararg styleClass: String): TextArea = styledTextArea(text =
        text, styleClass = *styleClass) { }

/**
 * Add a styled [TextArea] to this manager.
 */
fun NodeManager.styledTextArea(text: String = "", vararg styleClass: String): TextArea =
        styledTextArea(text = text, styleClass = *styleClass) { }

/**
 * Create a styled [TextArea] with configuration block.
 */
inline fun styledTextArea(
    text: String = "",
    vararg styleClass: String,
    configuration: (@LayoutDslMarker TextArea).() -> Unit
): TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TextArea(text), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [TextArea] with configuration block to this manager.
 */
inline fun NodeManager.styledTextArea(
    text: String = "",
    vararg styleClass: String,
    configuration: (@LayoutDslMarker TextArea).() -> Unit
): TextArea {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TextArea(text), styleClass = *styleClass, configuration =
            configuration))
}

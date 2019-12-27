@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextArea
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [TextArea] with initialization block. */
inline fun textArea(
    text: String = "",
    configuration: (@LayoutsDslMarker TextArea).() -> Unit
): TextArea {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return TextArea(text).apply(configuration)
}

/** Add a [TextArea] to this manager. */
fun NodeManager.textArea(
    text: String = ""
): TextArea = addChild(TextArea(text))

/** Add a [TextArea] with initialization block to this manager. */
inline fun NodeManager.textArea(
    text: String = "",
    configuration: (@LayoutsDslMarker TextArea).() -> Unit
): TextArea {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(TextArea(text), configuration)
}

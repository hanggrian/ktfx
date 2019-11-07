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
    init: (@LayoutDslMarker TextArea).() -> Unit
): TextArea {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return TextArea(text).apply(init)
}
/** Add a [TextArea] to this manager. */
fun NodeManager.textArea(
    text: String = ""
): TextArea = addNode(TextArea(text))

/** Add a [TextArea] with initialization block to this manager. */
inline fun NodeManager.textArea(
    text: String = "",
    init: (@LayoutDslMarker TextArea).() -> Unit
): TextArea {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(TextArea(text), init)
}

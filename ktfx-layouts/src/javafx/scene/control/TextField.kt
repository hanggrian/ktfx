@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TextField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [TextField] with initialization block. */
inline fun textField(
    text: String = "",
    init: (@LayoutsDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return TextField(text).apply(init)
}

/** Add a [TextField] to this manager. */
fun NodeManager.textField(
    text: String = ""
): TextField = addNode(TextField(text))

/** Add a [TextField] with initialization block to this manager. */
inline fun NodeManager.textField(
    text: String = "",
    init: (@LayoutsDslMarker TextField).() -> Unit
): TextField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(TextField(text), init)
}

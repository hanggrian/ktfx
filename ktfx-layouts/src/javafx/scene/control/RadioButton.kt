@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.RadioButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [RadioButton] with initialization block. */
inline fun radioButton(
    text: String? = null,
    init: (@KtfxLayoutsDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return RadioButton(text).apply(init)
}

/** Add a [RadioButton] to this manager. */
fun NodeManager.radioButton(
    text: String? = null
): RadioButton = addNode(RadioButton(text))

/** Add a [RadioButton] with initialization block to this manager. */
inline fun NodeManager.radioButton(
    text: String? = null,
    init: (@KtfxLayoutsDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(RadioButton(text), init)
}

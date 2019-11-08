@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXRadioButton] with initialization block. */
inline fun jfxRadioButton(
    text: String? = null,
    init: JFXRadioButton.() -> Unit
): JFXRadioButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXRadioButton(text).apply(init)
}
/** Add a [JFXRadioButton] to this manager. */
fun NodeManager.jfxRadioButton(
    text: String? = null
): JFXRadioButton = addNode(JFXRadioButton(text))

/** Add a [JFXRadioButton] with initialization block to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    init: JFXRadioButton.() -> Unit
): JFXRadioButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXRadioButton(text), init)
}

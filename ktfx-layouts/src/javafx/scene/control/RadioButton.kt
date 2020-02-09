@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.RadioButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [RadioButton] with configurationialization block. */
inline fun radioButton(
    text: String? = null,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return RadioButton(text).apply(configuration)
}

/** Add a [RadioButton] to this manager. */
fun NodeManager.radioButton(
    text: String? = null
): RadioButton = addChild(RadioButton(text))

/** Add a [RadioButton] with configurationialization block to this manager. */
inline fun NodeManager.radioButton(
    text: String? = null,
    configuration: (@LayoutDslMarker RadioButton).() -> Unit
): RadioButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(RadioButton(text), configuration)
}

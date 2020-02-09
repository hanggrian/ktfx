@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXRadioButton] with configurationialization block. */
inline fun jfxRadioButton(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXRadioButton(text).apply(configuration)
}

/** Add a [JFXRadioButton] to this manager. */
fun NodeManager.jfxRadioButton(
    text: String? = null
): JFXRadioButton = addChild(JFXRadioButton(text))

/** Add a [JFXRadioButton] with configurationialization block to this manager. */
inline fun NodeManager.jfxRadioButton(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXRadioButton).() -> Unit
): JFXRadioButton {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXRadioButton(text), configuration)
}

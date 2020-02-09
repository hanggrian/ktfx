@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTextArea] with configurationialization block. */
inline fun jfxTextArea(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTextArea(text).apply(configuration)
}

/** Add a [JFXTextArea] to this manager. */
fun NodeManager.jfxTextArea(
    text: String? = null
): JFXTextArea = addChild(JFXTextArea(text))

/** Add a [JFXTextArea] with configurationialization block to this manager. */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTextArea(text), configuration)
}

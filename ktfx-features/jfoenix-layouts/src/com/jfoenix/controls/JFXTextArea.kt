@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTextArea] with initialization block. */
inline fun jfxTextArea(
    text: String? = null,
    init: (@LayoutsDslMarker JFXTextArea).() -> Unit
): JFXTextArea {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXTextArea(text).apply(init)
}

/** Add a [JFXTextArea] to this manager. */
fun NodeManager.jfxTextArea(
    text: String? = null
): JFXTextArea = addNode(JFXTextArea(text))

/** Add a [JFXTextArea] with initialization block to this manager. */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    init: (@LayoutsDslMarker JFXTextArea).() -> Unit
): JFXTextArea {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXTextArea(text), init)
}

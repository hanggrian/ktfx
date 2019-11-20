@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTextField] with initialization block. */
inline fun jfxTextField(
    text: String? = null,
    init: (@KtfxLayoutsDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXTextField(text).apply(init)
}

/** Add a [JFXTextField] to this manager. */
fun NodeManager.jfxTextField(
    text: String? = null
): JFXTextField = addNode(JFXTextField(text))

/** Add a [JFXTextField] with initialization block to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    init: (@KtfxLayoutsDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXTextField(text), init)
}

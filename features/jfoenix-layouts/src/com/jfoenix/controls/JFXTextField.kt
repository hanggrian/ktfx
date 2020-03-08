@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXTextField] with configuration block. */
inline fun jfxTextField(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXTextField(text).apply(configuration)
}

/** Add a [JFXTextField] to this manager. */
fun NodeManager.jfxTextField(
    text: String? = null
): JFXTextField = addChild(JFXTextField(text))

/** Add a [JFXTextField] with configuration block to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXTextField(text), configuration)
}

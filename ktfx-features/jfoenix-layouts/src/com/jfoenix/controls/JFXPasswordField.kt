@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXPasswordField
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXPasswordField] with initialization block. */
inline fun jfxPasswordField(
    init: (@LayoutsDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXPasswordField().apply(init)
}

/** Add a [JFXPasswordField] to this manager. */
fun NodeManager.jfxPasswordField(): JFXPasswordField =
    addNode(JFXPasswordField())

/** Add a [JFXPasswordField] with initialization block to this manager. */
inline fun NodeManager.jfxPasswordField(
    init: (@LayoutsDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXPasswordField(), init)
}

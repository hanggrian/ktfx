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
import ktfx.layouts.addChild

/** Create a [JFXPasswordField] with initialization block. */
inline fun jfxPasswordField(
    configuration: (@LayoutsDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXPasswordField().apply(configuration)
}

/** Add a [JFXPasswordField] to this manager. */
fun NodeManager.jfxPasswordField(): JFXPasswordField =
    addChild(JFXPasswordField())

/** Add a [JFXPasswordField] with initialization block to this manager. */
inline fun NodeManager.jfxPasswordField(
    configuration: (@LayoutsDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXPasswordField(), configuration)
}

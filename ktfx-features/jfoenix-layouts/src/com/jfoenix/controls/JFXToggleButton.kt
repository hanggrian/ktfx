@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXToggleButton] with initialization block. */
inline fun jfxToggleButton(
    init: (@LayoutsDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXToggleButton().apply(init)
}

/** Add a [JFXToggleButton] to this manager. */
fun NodeManager.jfxToggleButton(): JFXToggleButton =
    addNode(JFXToggleButton())

/** Add a [JFXToggleButton] with initialization block to this manager. */
inline fun NodeManager.jfxToggleButton(
    init: (@LayoutsDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXToggleButton(), init)
}

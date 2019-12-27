@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXDrawersStack] with initialization block. */
inline fun jfxDrawersStack(
    configuration: (@LayoutsDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXDrawersStack().apply(configuration)
}

/** Add a [JFXDrawersStack] to this manager. */
fun NodeManager.jfxDrawersStack(): JFXDrawersStack = addChild(JFXDrawersStack())

/** Add a [JFXDrawersStack] with initialization block to this manager. */
inline fun NodeManager.jfxDrawersStack(
    configuration: (@LayoutsDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXDrawersStack(), configuration)
}

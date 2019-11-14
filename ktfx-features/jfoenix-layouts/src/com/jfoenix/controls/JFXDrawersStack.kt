@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDrawersStack] with initialization block. */
inline fun jfxDrawersStack(
    init: JFXDrawersStack.() -> Unit
): JFXDrawersStack {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXDrawersStack().apply(init)
}

/** Add a [JFXDrawersStack] to this manager. */
fun NodeManager.jfxDrawersStack(): JFXDrawersStack =
    addNode(JFXDrawersStack())

/** Add a [JFXDrawersStack] with initialization block to this manager. */
inline fun NodeManager.jfxDrawersStack(
    init: JFXDrawersStack.() -> Unit
): JFXDrawersStack {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXDrawersStack(), init)
}

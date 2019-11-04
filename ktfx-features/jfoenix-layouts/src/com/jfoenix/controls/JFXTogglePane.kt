@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTogglePane] with initialization block. */
inline fun jfxTogglePane(
    init: (@LayoutDslMarker JFXTogglePane).() -> Unit
): JFXTogglePane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return JFXTogglePane().apply(init)
}
/** Add a [JFXTogglePane] to this manager. */
fun NodeManager.jfxTogglePane(): JFXTogglePane =
    addNode(JFXTogglePane())

/** Add a [JFXTogglePane] with initialization block to this manager. */
inline fun NodeManager.jfxTogglePane(
    init: (@LayoutDslMarker JFXTogglePane).() -> Unit
): JFXTogglePane {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(JFXTogglePane(), init)
}

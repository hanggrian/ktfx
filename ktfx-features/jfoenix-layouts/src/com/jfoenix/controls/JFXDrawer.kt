@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDrawer] with initialization block. */
inline fun jfxDrawer(
    init: (@LayoutDslMarker JFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXDrawer().apply(init)
}
/** Add a [JFXDrawer] to this manager. */
fun NodeManager.jfxDrawer(): JFXDrawer =
    addNode(JFXDrawer())

/** Add a [JFXDrawer] with initialization block to this manager. */
inline fun NodeManager.jfxDrawer(
    init: (@LayoutDslMarker JFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXDrawer(), init)
}

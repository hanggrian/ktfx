@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXNodesList] with initialization block. */
inline fun jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXNodesList().apply(init)
}
/** Add a [JFXNodesList] to this manager. */
fun NodeManager.jfxNodesList(): JFXNodesList =
    addNode(JFXNodesList())

/** Add a [JFXNodesList] with initialization block to this manager. */
inline fun NodeManager.jfxNodesList(
    init: (@LayoutDslMarker JFXNodesList).() -> Unit
): JFXNodesList {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXNodesList(), init)
}

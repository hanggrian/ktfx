@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXToggleNode] with initialization block. */
inline fun jfxToggleNode(
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return JFXToggleNode(graphic).apply(init)
}
/** Add a [JFXToggleNode] to this manager. */
fun NodeManager.jfxToggleNode(
    graphic: Node? = null
): JFXToggleNode = addNode(JFXToggleNode(graphic))

/** Add a [JFXToggleNode] with initialization block to this manager. */
inline fun NodeManager.jfxToggleNode(
    graphic: Node? = null,
    init: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    return addNode(JFXToggleNode(graphic), init)
}

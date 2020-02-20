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
import ktfx.layouts.addChild

/** Create a [JFXToggleNode] with configuration block. */
inline fun jfxToggleNode(
    graphic: Node? = null,
    configuration: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXToggleNode(graphic).apply(configuration)
}

/** Add a [JFXToggleNode] to this manager. */
fun NodeManager.jfxToggleNode(
    graphic: Node? = null
): JFXToggleNode = addChild(JFXToggleNode(graphic))

/** Add a [JFXToggleNode] with configuration block to this manager. */
inline fun NodeManager.jfxToggleNode(
    graphic: Node? = null,
    configuration: (@LayoutDslMarker JFXToggleNode).() -> Unit
): JFXToggleNode {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXToggleNode(graphic), configuration)
}

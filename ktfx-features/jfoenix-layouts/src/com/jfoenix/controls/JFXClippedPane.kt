@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXClippedPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXClippedPane : JFXClippedPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { children += it }
}

/** Create a [JFXClippedPane] with initialization block. */
inline fun jfxClippedPane(
    init: (@LayoutsDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXClippedPane().apply(init)
}

/** Add a [JFXClippedPane] to this manager. */
fun NodeManager.jfxClippedPane(): JFXClippedPane =
    addNode(KtfxJFXClippedPane())

/** Add a [JFXClippedPane] with initialization block to this manager. */
inline fun NodeManager.jfxClippedPane(
    init: (@LayoutsDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXClippedPane(), init)
}

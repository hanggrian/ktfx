@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXDrawer] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXDrawer : JFXDrawer(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content += it }
}

/** Create a [JFXDrawer] with initialization block. */
inline fun jfxDrawer(
    init: KtfxJFXDrawer.() -> Unit
): JFXDrawer {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXDrawer().apply(init)
}

/** Add a [JFXDrawer] to this manager. */
fun NodeManager.jfxDrawer(): JFXDrawer =
    addNode(JFXDrawer())

/** Add a [JFXDrawer] with initialization block to this manager. */
inline fun NodeManager.jfxDrawer(
    init: KtfxJFXDrawer.() -> Unit
): JFXDrawer {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXDrawer(), init)
}

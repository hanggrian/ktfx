@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXTogglePane] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxJFXTogglePane : JFXTogglePane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { contentNode = it }
}

/** Create a [JFXTogglePane] with initialization block. */
inline fun jfxTogglePane(
    init: (@LayoutsDslMarker KtfxJFXTogglePane).() -> Unit
): JFXTogglePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXTogglePane().apply(init)
}

/** Add a [JFXTogglePane] to this manager. */
fun NodeManager.jfxTogglePane(): JFXTogglePane =
    addNode(JFXTogglePane())

/** Add a [JFXTogglePane] with initialization block to this manager. */
inline fun NodeManager.jfxTogglePane(
    init: (@LayoutsDslMarker KtfxJFXTogglePane).() -> Unit
): JFXTogglePane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXTogglePane(), init)
}

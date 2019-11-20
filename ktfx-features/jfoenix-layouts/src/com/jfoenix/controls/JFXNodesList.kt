@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXNodesList] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXNodesList : JFXNodesList(), NodeManager {

    override fun <T : Node> addNode(node: T): T =
        node.also { children += it }
}

/** Create a [JFXNodesList] with initialization block. */
inline fun jfxNodesList(
    init: (@KtfxLayoutsDslMarker KtfxJFXNodesList).() -> Unit
): JFXNodesList {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXNodesList().apply(init)
}

/** Add a [JFXNodesList] to this manager. */
fun NodeManager.jfxNodesList(): JFXNodesList =
    addNode(JFXNodesList())

/** Add a [JFXNodesList] with initialization block to this manager. */
inline fun NodeManager.jfxNodesList(
    init: (@KtfxLayoutsDslMarker KtfxJFXNodesList).() -> Unit
): JFXNodesList {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXNodesList(), init)
}

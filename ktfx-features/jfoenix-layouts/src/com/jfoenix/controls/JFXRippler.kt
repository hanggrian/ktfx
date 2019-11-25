@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/**
 * [JFXRippler] with dynamic-layout dsl support.
 * Invoking dsl will only set its children.
 */
open class KtfxJFXRippler : JFXRippler(), NodeManager {

    final override fun <T : Node> addNode(node: T): T = node.also { control = it }
}

/** Create a [JFXRippler] with initialization block. */
inline fun jfxRippler(
    init: (@KtfxLayoutsDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXRippler().apply(init)
}

/** Add a [JFXRippler] to this manager. */
fun NodeManager.jfxRippler(): JFXRippler =
    addNode(KtfxJFXRippler())

/** Add a [JFXRippler] with initialization block to this manager. */
inline fun NodeManager.jfxRippler(
    init: (@KtfxLayoutsDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxJFXRippler(), init)
}
